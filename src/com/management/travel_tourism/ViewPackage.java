package com.management.travel_tourism;

import javax.swing.*;
import java.awt.*;

public class ViewPackage
{
    private JFrame frame;
    ViewPackage()
    {
        System.out.println(ClassLoader.getSystemResource(""));
        frame = new JFrame("View Packages");
        frame.setBounds(550,220,900,600);
        frame.setLocationRelativeTo(null);


        JTabbedPane tab = new JTabbedPane();
//        ==================================================================================================================
//        ==================================================================================================================
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.white);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./com/management/travel_tourism/icons/package1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i11 = new JLabel(i3);
        i11.setBounds(400,0,450,420);
        p1.add(i11);

        JLabel lblName = new JLabel("GOLD PACKAGE");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        lblName.setBounds(50, 5, 350, 53);
        p1.add(lblName);

        JLabel l3 = new JLabel("6 days and 7 Nights");
        l3.setForeground(Color.RED);
        l3.setBounds(35, 70, 200, 14);
        p1.add(l3);

        JLabel lblId = new JLabel("Airport Assistance at Aiport");
        lblId.setForeground(Color.BLUE);
        lblId.setBounds(35, 110, 200, 14);
        p1.add(lblId);

        JLabel l2 = new JLabel("Half Day City Tour");
        l2.setForeground(Color.RED);
        l2.setBounds(35, 150, 200, 14);
        p1.add(l2);

        JLabel lblName_1 = new JLabel("Welcome drinks on Arrival");
        lblName_1.setForeground(Color.BLUE);
        lblName_1.setBounds(35, 190, 200, 14);
        p1.add(lblName_1);

        JLabel lblGender = new JLabel("Daily Buffet");
        lblGender.setForeground(Color.RED);
        lblGender.setBounds(35, 230, 200, 14);
        p1.add(lblGender);

        JLabel lblCountry = new JLabel("Full Day 3 Island Cruise");
        lblCountry.setForeground(Color.BLUE);
        lblCountry.setBounds(35, 270, 200, 14);
        p1.add(lblCountry);

        JLabel lblReserveRoomNumber = new JLabel("English Speaking Guide");
        lblReserveRoomNumber.setForeground(Color.RED);
        lblReserveRoomNumber.setBounds(35, 310, 200, 14);
        p1.add(lblReserveRoomNumber);

        JLabel lblCheckInStatus = new JLabel("BOOK NOW");
        lblCheckInStatus.setForeground(Color.BLUE);
        lblCheckInStatus.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblCheckInStatus.setBounds(35, 400, 200, 30);
        p1.add(lblCheckInStatus);

        JLabel lblDeposite = new JLabel("Summer Special");
        lblDeposite.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        lblDeposite.setBounds(35, 460, 400, 40);
        p1.add(lblDeposite);

        JLabel la1 = new JLabel("Rs 12000 only");
        la1.setForeground(Color.RED);
        la1.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        la1.setBounds(600, 460, 400, 40);
        p1.add(la1);


        tab.add("Package 1", p1);
        frame.add(tab);

//        ==================================================================================================================
//        ==================================================================================================================
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.white);

        ImageIcon ii2 = new ImageIcon(ClassLoader.getSystemResource("./com/management/travel_tourism/icons/package2.jpg"));
        Image ii3 = ii2.getImage().getScaledInstance(550,300,Image.SCALE_DEFAULT);
        ImageIcon ii4 = new ImageIcon(ii3);
        JLabel iil5 = new JLabel(ii4);
        iil5.setBounds(400,0,450,420);
        p2.add(iil5);

        JLabel lblName2 = new JLabel("SILVER PACKAGE");
        lblName2.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        lblName2.setBounds(50, 5, 350, 53);
        p2.add(lblName2);

        JLabel l23 = new JLabel("4 days and 3 Nights");
        l23.setForeground(Color.RED);
        l23.setBounds(35, 70, 200, 14);
        p2.add(l23);

        JLabel lblId2 = new JLabel("Toll Free and Entrance Free Tickets");
        lblId2.setForeground(Color.BLUE);
        lblId2.setBounds(35, 110, 200, 14);
        p2.add(lblId2);

        JLabel l22 = new JLabel("Meet and Greet at Aiport");
        l22.setForeground(Color.RED);
        l22.setBounds(35, 150, 200, 14);
        p2.add(l22);

        JLabel lblName_2 = new JLabel("Welcome drinks on Arrival");
        lblName_2.setForeground(Color.BLUE);
        lblName_2.setBounds(35, 190, 200, 14);
        p2.add(lblName_2);

        JLabel lblGender2 = new JLabel("Night Safari");
        lblGender2.setForeground(Color.RED);
        lblGender2.setBounds(35, 230, 200, 14);
        p2.add(lblGender2);

        JLabel lblCountry2 = new JLabel("Full Day 3 Island Cruise");
        lblCountry2.setForeground(Color.BLUE);
        lblCountry2.setBounds(35, 270, 200, 14);
        p2.add(lblCountry2);

        JLabel lb27 = new JLabel("Cruise with Dinner");
        lb27.setForeground(Color.RED);
        lb27.setBounds(35, 310, 200, 14);
        p2.add(lb27);

        JLabel lbBook2 = new JLabel("BOOK NOW");
        lbBook2.setForeground(Color.BLUE);
        lbBook2.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lbBook2.setBounds(35, 400, 200, 30);
        p2.add(lbBook2);

        JLabel lbPlan2 = new JLabel("Winter Special");
        lbPlan2.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        lbPlan2.setBounds(35, 460, 400, 40);
        p2.add(lbPlan2);

        JLabel laPrice1 = new JLabel("Rs 25000 only");
        laPrice1.setForeground(Color.RED);
        laPrice1.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        laPrice1.setBounds(600, 460, 400, 40);
        p2.add(laPrice1);


        tab.add("Package 2", p2);
        frame.add(tab);

//        ==================================================================================================================
//        ==================================================================================================================
        JPanel p3 = new JPanel();
        p3.setLayout(null);
        p3.setBackground(Color.white);

        ImageIcon iii2 = new ImageIcon(ClassLoader.getSystemResource("./com/management/travel_tourism/icons/package3.jpg"));
        Image iii3 = iii2.getImage().getScaledInstance(550,300,Image.SCALE_DEFAULT);
        ImageIcon iii4 = new ImageIcon(iii3);
        JLabel iiil5 = new JLabel(iii4);
        iiil5.setBounds(400,0,450,420);
        p3.add(iiil5);

        JLabel lblName3 = new JLabel("BRONZE PACKAGE");
        lblName3.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        lblName3.setBounds(50, 5, 350, 53);
        p3.add(lblName3);

        JLabel l21 = new JLabel("6 days and 5 Nights");
        l21.setForeground(Color.RED);
        l21.setBounds(35, 70, 200, 14);
        p3.add(l21);

        JLabel lblId3 = new JLabel("Return Airfare");
        lblId3.setForeground(Color.BLUE);
        lblId3.setBounds(35, 110, 200, 14);
        p3.add(lblId3);

        JLabel l33 = new JLabel("Free Clubbing, Horse Riding & other Games");
        l33.setForeground(Color.RED);
        l33.setBounds(35, 150, 200, 14);
        p3.add(l33);

        JLabel lblName_3 = new JLabel("Welcome drinks on Arrival");
        lblName_3.setForeground(Color.BLUE);
        lblName_3.setBounds(35, 190, 200, 14);
        p3.add(lblName_3);

        JLabel lblGender3 = new JLabel("Daily Buffet");
        lblGender3.setForeground(Color.RED);
        lblGender3.setBounds(35, 230, 200, 14);
        p3.add(lblGender3);

        JLabel lblCountry3 = new JLabel("Stay in 5 Star Hotel");
        lblCountry3.setForeground(Color.BLUE);
        lblCountry3.setBounds(35, 270, 200, 14);
        p3.add(lblCountry3);

        JLabel lb23 = new JLabel("BBQ Dinner");
        lb23.setForeground(Color.RED);
        lb23.setBounds(35, 310, 200, 14);
        p3.add(lb23);

        JLabel lbBook3 = new JLabel("BOOK NOW");
        lbBook3.setForeground(Color.BLUE);
        lbBook3.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lbBook3.setBounds(35, 400, 200, 30);
        p3.add(lbBook3);

        JLabel lbPlan3 = new JLabel("Sunny Special");
        lbPlan3.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        lbPlan3.setBounds(35, 460, 400, 40);
        p3.add(lbPlan3);

        JLabel laPrice3 = new JLabel("Rs 32000 only");
        laPrice3.setForeground(Color.RED);
        laPrice3.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        laPrice3.setBounds(600, 460, 400, 40);
        p3.add(laPrice3);


        tab.add("Package 3", p3);
        frame.add(tab);

        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new ViewPackage();
    }
}
