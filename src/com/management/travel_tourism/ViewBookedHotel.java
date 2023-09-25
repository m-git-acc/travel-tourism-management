package com.management.travel_tourism;

import java.awt.*;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ViewBookedHotel
{
    private JFrame frame;
    private Choice c1;
    public ViewBookedHotel(String username)
    {
        frame = new JFrame("View Booked Hotel");
        frame.setBounds(580, 220, 850, 600);
        frame.setLayout(null);
        frame.setLayout(null);
        frame.setUndecorated(true);


        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("./com/management/travel_tourism/icons/bookedDetails.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 350,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450,50,350,350);
        frame.add(la1);

        JLabel lblName = new JLabel("VIEW BOOKED HOTEL DETAILS");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(88, 11, 350, 53);
        frame.add(lblName);

        JLabel lb3 = new JLabel("Username :");
        lb3.setBounds(35, 70, 200, 14);
        frame.add(lb3);

        JLabel l1 = new JLabel();
        l1.setBounds(271, 70, 200, 14);
        frame.add(l1);

        JLabel lblId = new JLabel("Name :");
        lblId.setBounds(35, 110, 200, 14);
        frame.add(lblId);

        JLabel l2 = new JLabel();
        l2.setBounds(271, 110, 200, 14);
        frame.add(l2);

        JLabel lb2 = new JLabel("Number of Rooms :");
        lb2.setBounds(35, 150, 200, 14);
        frame.add(lb2);

        JLabel l3 = new JLabel();
        l3.setBounds(271, 150, 200, 14);
        frame.add(l3);

        JLabel lblName_1 = new JLabel("Number of Days :");
        lblName_1.setBounds(35, 190, 200, 14);
        frame.add(lblName_1);

        JLabel l4 = new JLabel();
        l4.setBounds(271, 190, 200, 14);
        frame.add(l4);


        JLabel lblGender = new JLabel("AC / Non-AC :");
        lblGender.setBounds(35, 230, 200, 14);
        frame.add(lblGender);

        JLabel l5 = new JLabel();
        l5.setBounds(271, 230, 200, 14);
        frame.add(l5);

        JLabel lblCountry = new JLabel("Food Included (Yes/No) :");
        lblCountry.setBounds(35, 270, 200, 14);
        frame.add(lblCountry);

        JLabel l6 = new JLabel();
        l6.setBounds(271, 270, 200, 14);
        frame.add(l6);

        JLabel lblReserveRoomNumber = new JLabel("ID Name :");
        lblReserveRoomNumber.setBounds(35, 310, 200, 14);
        frame.add(lblReserveRoomNumber);

        JLabel l7 = new JLabel();
        l7.setBounds(271, 310, 200, 14);
        frame.add(l7);

        JLabel lblCheckInStatus = new JLabel("ID Number :");
        lblCheckInStatus.setBounds(35, 350, 200, 14);
        frame.add(lblCheckInStatus);

        JLabel l8 = new JLabel();
        l8.setBounds(271, 350, 200, 14);
        frame.add(l8);


        JLabel lblDeposite = new JLabel("Phone :");
        lblDeposite.setBounds(35, 390, 200, 14);
        frame.add(lblDeposite);

        JLabel l9 = new JLabel();
        l9.setBounds(271, 390, 200, 14);
        frame.add(l9);

        JLabel la2 = new JLabel("Cost :");
        la2.setBounds(35, 430, 200, 14);
        frame.add(la2);
        JLabel l10 = new JLabel();
        l10.setBounds(271, 430, 200, 14);
        frame.add(l10);

        try{
            Connection con = Database_Connection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from bookHotel where username=?");
            ps.setString(1,username);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                l1.setText(rs.getString("username"));
                l2.setText(rs.getString("hotel"));
                l3.setText(rs.getString("rooms"));
                l4.setText(rs.getString("days"));
                l5.setText(rs.getString("ac"));
                l6.setText(rs.getString("food"));
                l7.setText(rs.getString("id"));
                l8.setText(rs.getString("number"));
                l9.setText(rs.getString("phone"));
                l10.setText(rs.getString("price"));
            }
        }catch(Exception e){e.printStackTrace();}


        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        btnExit.setBounds(160, 470, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        frame.add(btnExit);

        frame.setVisible(true);
    }
}