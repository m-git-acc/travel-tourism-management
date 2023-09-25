package com.management.travel_tourism;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Dashboard
{
    JFrame frame;
    Dashboard(String user, String name)
    {
        System.out.println(user);
        frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setUndecorated(true);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        frame.add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./com/management/travel_tourism/icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(60,60, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel top_icon = new JLabel(i3);
        top_icon.setBounds(5,0,70,70);
        p1.add(top_icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,5,280,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        p1.add(heading);

        JButton logout = new JButton("Logout");
        logout.setBounds(1500,0,100,30);
        logout.addActionListener(
                e -> {
                    frame.setVisible(false);
                    new Login();
                });
        p1.add(logout);

        JButton exit = new JButton("EXIT");
        exit.setBounds(1500,31,100,30);
        exit.addActionListener(e -> System.exit(0));
        p1.add(exit);


        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,250,900);
        frame.add(p2);

        JButton b1_add_pro = new JButton("Add Personal Details");
        b1_add_pro.setBounds(0,0,250,50);
        b1_add_pro.setFont(new Font("Tahoma",Font.PLAIN,20));
        b1_add_pro.setBackground(new Color(5,96,234));
        b1_add_pro.setForeground(Color.white);
        b1_add_pro.addActionListener(e->{new AddPerDet(user,name);});
        p2.add(b1_add_pro);

        JButton b2_up_det  = new JButton("Update Personal Details");
        b2_up_det.setBounds(0,50,250,50);
        b2_up_det.setFont(new Font("Tahoma",Font.PLAIN,20));
        b2_up_det.setBackground(new Color(5,96,234));
        b2_up_det.setForeground(Color.white);
        b2_up_det.addActionListener(e-> new UpdatePerDet(user));
        p2.add(b2_up_det);

        JButton b3_vw_det = new JButton("View Details");
        b3_vw_det.setBounds(0,100,250,50);
        b3_vw_det.setFont(new Font("Tahoma",Font.PLAIN,20));
        b3_vw_det.setBackground(new Color(5,96,234));
        b3_vw_det.setForeground(Color.white);
        b3_vw_det.addActionListener(e->new ViewDetails(user));
        p2.add(b3_vw_det);

        JButton b4_del_det = new JButton("Delete Personal Details");
        b4_del_det.setBounds(0,150,250,50);
        b4_del_det.setFont(new Font("Tahoma",Font.PLAIN,20));
        b4_del_det.setBackground(new Color(5,96,234));
        b4_del_det.setForeground(Color.white);
        b4_del_det.addActionListener(e->new DeletePerDet(user));
        p2.add(b4_del_det);

        JButton b5_ck_pkg = new JButton("Check Package");
        b5_ck_pkg.setBounds(0,200,250,50);
        b5_ck_pkg.setFont(new Font("Tahoma",Font.PLAIN,20));
        b5_ck_pkg.setBackground(new Color(5,96,234));
        b5_ck_pkg.setForeground(Color.white);
        b5_ck_pkg.addActionListener(e->{});
        p2.add(b5_ck_pkg);

        JButton b6_bk_pkg= new JButton("Book Package");
        b6_bk_pkg.setBounds(0,250,250,50);
        b6_bk_pkg.setFont(new Font("Tahoma",Font.PLAIN,20));
        b6_bk_pkg.setBackground(new Color(5,96,234));
        b6_bk_pkg.setForeground(Color.white);
        b6_bk_pkg.addActionListener(e->{new BookPackage(user);});
        p2.add(b6_bk_pkg);

        JButton b7_vk_pkg = new JButton("View Package");
        b7_vk_pkg.setBounds(0,300,250,50);
        b7_vk_pkg.setFont(new Font("Tahoma",Font.PLAIN,20));
        b7_vk_pkg.setBackground(new Color(5,96,234));
        b7_vk_pkg.setForeground(Color.white);
        b7_vk_pkg.addActionListener(e->{new CheckPackage();});
        p2.add(b7_vk_pkg);

        JButton b8_vw_htl = new JButton("View Hotels");
        b8_vw_htl.setBounds(0,350,250,50);
        b8_vw_htl.setFont(new Font("Tahoma",Font.PLAIN,20));
        b8_vw_htl.setBackground(new Color(5,96,234));
        b8_vw_htl.setForeground(Color.white);
        b8_vw_htl.addActionListener(e->{});
        p2.add(b8_vw_htl);

        JButton b9_bk_htl = new JButton("Book Hotel");
        b9_bk_htl.setBounds(0,400,250,50);
        b9_bk_htl.setFont(new Font("Tahoma",Font.PLAIN,20));
        b9_bk_htl.setBackground(new Color(5,96,234));
        b9_bk_htl.setForeground(Color.white);
        b9_bk_htl.addActionListener(e->{});
        p2.add(b9_bk_htl);

        JButton b10_vbh = new JButton("View Booked Hotel");
        b10_vbh.setBounds(0,450,250,50);
        b10_vbh.setFont(new Font("Tahoma",Font.PLAIN,20));
        b10_vbh.setBackground(new Color(5,96,234));
        b10_vbh.setForeground(Color.white);
        b10_vbh.addActionListener(e->{});
        p2.add(b10_vbh);

        JButton b11_dest= new JButton("Destinations");
        b11_dest.setBounds(0,500,250,50);
        b11_dest.setFont(new Font("Tahoma",Font.PLAIN,20));
        b11_dest.setBackground(new Color(5,96,234));
        b11_dest.setForeground(Color.white);
        b11_dest.addActionListener(e->{});
        p2.add(b11_dest);

        JButton b12_pay= new JButton("Payment");
        b12_pay.setBounds(0,550,250,50);
        b12_pay.setFont(new Font("Tahoma",Font.PLAIN,20));
        b12_pay.setBackground(new Color(5,96,234));
        b12_pay.setForeground(Color.white);
        b12_pay.addActionListener(e->{});
        p2.add(b12_pay);

        JButton b13_cal = new JButton("Calculator");
        b13_cal.setBounds(0,600,250,50);
        b13_cal.setFont(new Font("Tahoma",Font.PLAIN,20));
        b13_cal.setBackground(new Color(5,96,234));
        b13_cal.setForeground(Color.white);
        b13_cal.addActionListener(
                e->{
                    try {Runtime.getRuntime().exec("calc.exe");}
                    catch (Exception ex) {ex.printStackTrace();}
                });
        p2.add(b13_cal);

        JButton b14_ntpd = new JButton("Notepad");
        b14_ntpd.setBounds(0,650,250,50);
        b14_ntpd.setFont(new Font("Tahoma",Font.PLAIN,20));
        b14_ntpd.setBackground(new Color(5,96,234));
        b14_ntpd.setForeground(Color.white);
        b14_ntpd.addActionListener(
                e->{
                    try {Runtime.getRuntime().exec("notepad.exe");}
                    catch (IOException ex) {ex.printStackTrace();}
                });
        p2.add(b14_ntpd);

        JButton b15_abt= new JButton("About");
        b15_abt.setBounds(0,700,250,50);
        b15_abt.setFont(new Font("Tahoma",Font.PLAIN,20));
        b15_abt.setBackground(new Color(5,96,234));
        b15_abt.setForeground(Color.white);
        b15_abt.addActionListener(e->{new About();});
        p2.add(b15_abt);

        ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("./com/management/travel_tourism/icons/home.jpg"));
        Image i7 = i6.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i8 = new ImageIcon(i7);
        JLabel i9 = new JLabel(i8);
        i9.setBounds(0,0,1650,1000);
        frame.add(i9);

        JLabel ad = new JLabel("Travel and Tourism Management");
        ad.setForeground(new Color(24, 51, 69,203));
        ad.setFont(new Font("Raleway",Font.BOLD,60));
        ad.setBounds(480,90,1000,75);
        i9.add(ad);


        frame.setVisible(true);
    }
}
