package com.chikenStriker;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Bullet implements MouseListener {
    int counter;
    int x , y ;
    private int ya=2;
    boolean isDead=false;
    public Bullet(int counter){
        this.counter =counter;
    }

    public void move(){
        y-=ya;
    }
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(237 , 28 , 36));
        g2.fillRect(x-12 , y-50, 10 , 15);
    }

    public Rectangle getBounds(){
        return new Rectangle(x-12 , y-50 , 10 , 15);
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x= e.getX();
        y = e.getY();
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
}
