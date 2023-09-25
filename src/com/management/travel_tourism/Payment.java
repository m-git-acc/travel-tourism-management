package com.management.travel_tourism;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Payment
{
    private JFrame frame;

    public Payment()
    {
        frame = new JFrame("Payment");
        frame.setLayout(null);
        frame.setBounds(600, 220, 800, 600);

        JLabel label=new JLabel("Pay using Paytm");
        label.setFont(new Font("Raleway", Font.BOLD, 40));
        label.setBounds(50, 20, 350, 45);
        frame.add(label);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("./com/management/travel_tourism/icons/paytm.jpeg"));
        Image i8 = i7.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l4 = new JLabel(i9);
        l4.setBounds(0, 150, 800, 600);
        frame.add(l4);

        JButton pay = new JButton("Pay");
        pay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Paytm();
            }
        });
        pay.setBounds(420, 20, 80, 40);
        frame.add(pay);

        JButton back=new JButton("Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        back.setBounds(510, 20, 80, 40);
        frame.add(back);

        frame.getContentPane().setBackground(Color.WHITE);
        frame.setVisible(true);

    }
}