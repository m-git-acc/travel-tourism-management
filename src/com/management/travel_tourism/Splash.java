package com.management.travel_tourism;

import javax.swing.*;
import java.awt.*;

public class Splash
{
    private JFrame frame;
    private void Splash()
    {
        frame = new JFrame();
        frame.setUndecorated(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./com/management/travel_tourism/icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        frame.add(l1);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Runnable run1 = () ->
        {
            try
            {
               Thread.sleep(4000);
               frame.setVisible(false);
               new Login();
            }
            catch (Exception e) {e.printStackTrace();}
        };
        Thread thread = new Thread(run1);
        thread.start();
    }

    public static void main(String[] args)
    {
        System.out.println(ClassLoader.getSystemResource(""));
        Splash fram = new Splash();
        fram.Splash();
        for (int i = 1; i<=500; i++, i+=0.99)
        {
            fram.frame.setSize((i+i+(100)), (i+(100)));
            fram.frame.setLocationRelativeTo(null);

            try {Thread.sleep(1);}
            catch (Exception e) {e.printStackTrace();}
        }
    }
}
