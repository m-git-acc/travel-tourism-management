package com.management.travel_tourism;

import javax.swing.*;
import java.awt.*;

public class About
{
    About()
    {
        String s = s = "The objective of the Travel and Tourism Management System"
                + "project is to develop a system that automates the processes "
                + "and activities of a travel and the purpose is to design a "
                + "system using which one can perform all operations related to "
                + "traveling.\n\n"
                + "This application will help in accessing the information related "
                + "to the travel to the particular destination with great ease. "
                + "The users can track the information related to their tours with "
                + "great ease through this application. The travel agency information "
                + "can also be obtained through this application.\n\n"
                + "Advantages of Project:"
                + "\nGives accurate information"
                + "\nSimplifies the manual work"
                + "\nIt minimizes the documentation related work"
                + "\nProvides up to date information"
                + "\nFriendly Environment by providing warning messages."
                + "\ntravelers details can be provided"
                + "\nbooking confirmation notification";

        JFrame frame = new JFrame();
        frame.setSize(440,450);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setUndecorated(true);

        JLabel head1 = new JLabel("Travel and Tourism Management System");
        head1.setBounds(25,24,400,40);
        head1.setForeground(Color.RED);
        head1.setFont(new Font("Arial",Font.BOLD,20));
        frame.add(head1);

        TextArea jta = new TextArea(s,10,40, TextArea.SCROLLBARS_VERTICAL_ONLY);
        jta.setBounds(15,80,415,270);
        jta.setBackground(Color.WHITE);
        jta.setFont(new Font("Arial",Font.PLAIN,15));
        jta.setEditable(false);
        frame.add(jta);

        JButton back = new JButton("B A C K");
        back.setBounds(160,390,100,25);
        frame.add(back);
        back.addActionListener(e->{frame.setVisible(false);});

        frame.setVisible(true);
    }
}
