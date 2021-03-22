package com.chikenStriker;

import java.awt.*;
import java.security.SecureRandom;

public class Blocks {
    private SecureRandom random = new SecureRandom();
    int x , y ;
    private int xa=1 , ya=1;


    public void move(boolean flag){
        if(flag){
            x=random.nextInt(650);
            y=0;
        }
        y+=ya;

    }
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(random.nextInt(200) , random.nextInt(100) , random.nextInt(200)));
        g2.fillRect(x , y , 15 , 15);
    }

    public Rectangle getBounds(){
        return new Rectangle(x , y , 15 , 15);
    }
}
