package com.chikenStriker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Player  implements MouseMotionListener , MouseListener {
    public int score=0;
    int x,y;
    private int life=3;

    public boolean lifeMinus(){
        if (life>0){
            life--;
            return true;
        }else {
            return false;
        }
    }

    public void resetLife(){
        life =3;
    }

    public int getLife(){
        return life;
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING ,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(255 ,201 ,14));
        g2.fillOval(x-30 , y-50, 50 , 70);
    }



    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x= e.getX();
        y = e.getY();

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

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
