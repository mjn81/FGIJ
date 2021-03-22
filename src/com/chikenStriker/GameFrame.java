package com.chikenStriker;

import javax.swing.*;

public class GameFrame extends JFrame {
    Panel p = new Panel();



    public GameFrame(){


        addMouseMotionListener(p);
        addMouseListener(p);


        add(p);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("this is 2nd test");
        setSize(700 , 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }


}
