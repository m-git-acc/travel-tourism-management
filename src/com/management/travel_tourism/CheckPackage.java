package com.management.travel_tourism;

import javax.swing.*;
import java.awt.*;

public class CheckPackage
{
    private JFrame frame;
    CheckPackage()
    {

        frame = new JFrame("Packages.");
        frame.setSize(900,550);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
//        frame.setUndecorated(true);

        JPanel p_1 = new JPanel();
        p_1.setBackground(Color.GREEN);
        p_1.setLayout(null);
        JPanel p_2 = new JPanel();
        p_2.setBackground(Color.RED);
        p_2.setLayout(null);
        JPanel p_3 = new JPanel();
        p_3.setBackground(Color.YELLOW);
        p_3.setLayout(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Package 1",p_1);
        tabs.add("Package 2",p_2);
        tabs.add("Package 3",p_3);
        frame.add(tabs);

        JLabel pck1 = new JLabel("GOLD PACKAGE");
        pck1.setBounds(30,10 ,500,50);
        pck1.setFont(new Font("Raleway",Font.BOLD, 40));
        pck1.setForeground(new Color(255,210,0));
        p_1.add(pck1);

        JLabel lable_11 = new JLabel("6 Days and 7 Nights");
        lable_11.setBounds(20,80 ,300,30);
        lable_11.setForeground(Color.GREEN);
        lable_11.setFont(new Font("Raleway",Font.PLAIN, 25));
        p_1.add(lable_11);

        JLabel lable_12 = new JLabel("Airport Assistance");
        lable_12.setBounds(20,130 ,300,30);
        lable_12.setForeground(Color.BLUE);
        lable_12.setFont(new Font("Raleway",Font.PLAIN, 25));
        p_1.add(lable_12);

        JLabel lable_13 = new JLabel("Half Day City Tour");
        lable_13.setBounds(20,180 ,300,30);
        lable_13.setForeground(Color.GREEN);
        lable_13.setFont(new Font("Raleway",Font.PLAIN, 25));
        p_1.add(lable_13);

        JLabel lable_14 = new JLabel("Daily Buffet");
        lable_14.setBounds(20,230 ,300,30);
        lable_14.setForeground(Color.BLUE);
        lable_14.setFont(new Font("Raleway",Font.PLAIN, 25));
        p_1.add(lable_14);

        JLabel lable_15 = new JLabel("Welcome Drinks on Arrival");
        lable_15.setBounds(20,280 ,300,30);
        lable_15.setForeground(Color.GREEN);
        lable_15.setFont(new Font("Raleway",Font.PLAIN, 25));
        p_1.add(lable_15);

        JLabel lable_16 = new JLabel("Full Day 3 Island Cruise");
        lable_16.setBounds(20,330 ,300,30);
        lable_16.setForeground(Color.BLUE);
        lable_16.setFont(new Font("Raleway",Font.PLAIN, 25));
        p_1.add(lable_16);

        JLabel lable_17 = new JLabel("English Speaking Guide");
        lable_17.setBounds(20,380 ,300,30);
        lable_17.setForeground(Color.GREEN);
        lable_17.setFont(new Font("Raleway",Font.PLAIN, 25));
        p_1.add(lable_17);

        JLabel lable_18 = new JLabel("BOOK NOW");
        lable_18.setBounds(12,435 ,300,30);
        lable_18.setForeground(Color.BLUE);
        lable_18.setFont(new Font("Raleway",Font.BOLD, 30));
        p_1.add(lable_18);

        JLabel lable_19 = new JLabel("SUMMER SPECIAL");
        lable_19.setBounds(330,450 ,300,30);
        lable_19.setForeground(Color.GREEN);
        lable_19.setFont(new Font("Raleway",Font.PLAIN, 25));
        p_1.add(lable_19);

        JLabel lable_110 = new JLabel("Rs. 12000/-");
        lable_110.setBounds(738,450,300,25);
        lable_110.setFont(new Font("Raleway",Font.PLAIN,25));
        lable_110.setForeground(Color.red);
        p_1.add(lable_110);




        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {new CheckPackage();}
}
