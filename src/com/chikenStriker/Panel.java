package com.chikenStriker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Panel extends JPanel implements Runnable , MouseListener , MouseMotionListener {
    private int counterBullet=0;
    private boolean state=true;
    private boolean flag=true;
    ArrayList<Thread> bulletT = new ArrayList<>();
    Thread blockT;
    Thread playerT;
    private Blocks blocks = new Blocks();
    private Player player = new Player();
    private ArrayList<Bullet> bullets = new ArrayList<>();
    private JLabel jll = new JLabel("your life is : " + player.getLife());
    private JLabel jlf = new JLabel("your score is : " + player.score);
    private void jlSet(){
        jll.setFont(new Font( "Segoe UI" , 0,16));
        jll.setForeground(Color.white);
        jll.setVisible(true);

        jlf.setFont(new Font( "Segoe UI" , 0,16));
        jlf.setForeground(Color.white);
        jlf.setVisible(true);


    }

    private void panelSet(){
        BoxLayout gl = new BoxLayout(this , BoxLayout.Y_AXIS);
        this.setLayout(gl);

    }

    public Panel(){
        jlSet();
        panelSet();
        this.add(jll);
        this.add(jlf);
        this.setBackground(new Color(6 , 36 , 66));

    }

    public void move() {
        blocks.move(flag);
        for(Bullet b : bullets){
            if(b.y <= 0){
               b.isDead=true;
            }else {
                b.move();
            }
        }

        flag=false;
        if(blocks.y==750){
            flag=true;
            if(player.lifeMinus()){
               jll.setText("your life is : " + player.getLife());
            }else{
                state=false;
            }

        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
        blocks.paint(g);
        player.paint(g);
        for (Bullet b : bullets){
            if(b!=null) {
                if (b.isDead) {
                    Thread killT = bulletT.get(b.counter);
                    killT.stop();
                } else {
                    b.paint(g);
                }
            }
        }
    }

    public boolean collision(){
        for(Bullet b : bullets){
            if(blocks.getBounds().intersects(b.getBounds())) {
                player.score += 10;
                jlf.setText("your score is : " + player.score);
                b.isDead=true;
                return true;
            }
        }
        return false;
    }

    @Override
    public void addNotify(){
        super.addNotify();
        blockT = new Thread(this);
        playerT = new Thread(this);
        blockT.start();
        playerT.start();
    }

    @Override
    public void run() {
        while (true){
            if(state) {
                if (collision()) {
                    flag = true;
                }
                repaint();
                move();
                try {
                    blockT.sleep(15);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }else {
                this.setVisible(false);

            }
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        bullets.add(new Bullet(counterBullet));
        Bullet temp = bullets.get(counterBullet);
        temp.mousePressed(e);
        bulletT.add(new Thread(this));
        Thread tempt = bulletT.get(counterBullet);
        tempt.start();
        counterBullet++;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        player.mouseMoved(e);
    }


}
