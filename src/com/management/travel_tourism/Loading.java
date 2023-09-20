package com.management.travel_tourism;

import javax.swing.*;
import java.awt.*;

public class Loading
{
    private JFrame frame;
    Loading(String name,String user)
    {
        frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(650,260);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setResizable(false);
        frame.setUndecorated(true);


        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(60,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Ralewary",Font.BOLD,35));
        frame.add(text);

        JProgressBar bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        frame.add(bar);

        JLabel loading = new JLabel("Loading, please wait...");
        loading.setBounds(200,140,150,30);
        loading.setForeground(Color.BLUE);
        loading.setFont(new Font("Ralewary",Font.PLAIN,14));
        frame.add(loading);


        JLabel username = new JLabel("welcome "+name);
        username.setBounds(20,210,400,40);
        username.setForeground(Color.green);
        username.setFont(new Font("Ralewary",Font.BOLD,25));
        frame.add(username);

        Runnable run1 = () ->
        {
            try
            {
                for (int i = 1; i<=101; i++)
                {
                    int max = bar.getMaximum();
                    int value = bar.getValue();

                    if (value<max) bar.setValue(bar.getValue()+1);
                    else
                    {
                        new Dashboard(user,name);
                        frame.setVisible(false);
                    }

                    Thread.sleep(30);
                }
            }
            catch (Exception e) {e.printStackTrace();}
        };
        Thread thread = new Thread(run1);
        thread.start();


        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
}
