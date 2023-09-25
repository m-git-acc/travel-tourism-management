package com.management.travel_tourism;

import java.awt.*;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookHotel
{
    private JFrame frame;
    JTextField t1,t2;
    Choice c1,c2,c3;

    public BookHotel(String username)
    {
        frame = new JFrame("Book Hotel");
        frame.setBounds(420, 220, 1100, 600);
        frame.setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("./com/management/travel_tourism/icons/book.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450,100,700,300);
        frame.add(la1);

        JLabel lblName = new JLabel("BOOK HOTEL");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(118, 11, 300, 53);
        frame.add(lblName);

        JLabel la2 = new JLabel("Username :");
        la2.setBounds(35, 70, 200, 14);
        frame.add(la2);

        JLabel l1 = new JLabel(username);
        l1.setBounds(271, 70, 200, 14);
        frame.add(l1);

        JLabel lblId = new JLabel("Select Hotel :");
        lblId.setBounds(35, 110, 200, 14);
        frame.add(lblId);

        c1 = new Choice();
        try
        {
            Connection dc = Database_Connection.getConnection();
            PreparedStatement ps = dc.prepareStatement("select name from hotels");

            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                c1.add(rs.getString("name"));
            }

            rs.close();
        }catch(Exception e){e.printStackTrace();}

        c1.setBounds(271, 110, 150, 30);
        frame.add(c1);

        JLabel la3 = new JLabel("Total Rooms");
        la3.setBounds(35, 150, 200, 14);
        frame.add(la3);

        t1 = new JTextField();
        t1.setText("0");
        t1.setBounds(271, 150, 150, 20);
        frame.add(t1);
        t1.setColumns(10);

        JLabel la4 = new JLabel("Number of Days");
        la4.setBounds(35, 190, 200, 14);
        frame.add(la4);

        t2 = new JTextField();
        t2.setText("0");
        t2.setBounds(271, 190, 150, 20);
        frame.add(t2);
        t2.setColumns(10);

        JLabel la5 = new JLabel("AC / Non-AC");
        la5.setBounds(35, 230, 200, 14);
        frame.add(la5);

        c2 = new Choice();
        c2.add("AC");
        c2.add("Non-AC");
        c2.setBounds(271, 230, 150, 30);
        frame.add(c2);


        JLabel la6 = new JLabel("Food Included :");
        la6.setBounds(35, 270, 200, 14);
        frame.add(la6);

        c3 = new Choice();
        c3.add("Yes");
        c3.add("No");
        c3.setBounds(271, 270, 150, 30);
        frame.add(c3);

        JLabel lbl1 = new JLabel("ID :");
        lbl1.setBounds(35, 310, 200, 14);
        frame.add(lbl1);

        JLabel l2 = new JLabel();
        l2.setBounds(271, 310, 200, 14);
        frame.add(l2);

        JLabel lbl2 = new JLabel("Number :");
        lbl2.setBounds(35, 350, 200, 14);
        frame.add(lbl2);

        JLabel l3 = new JLabel();
        l3.setBounds(271, 350, 200, 14);
        frame.add(l3);

        JLabel lbl3 = new JLabel("Phone :");
        lbl3.setBounds(35, 390, 200, 14);
        frame.add(lbl3);

        JLabel l4 = new JLabel();
        l4.setBounds(271, 390, 200, 14);
        frame.add(l4);


        JLabel lblDeposite = new JLabel("Total Price :");
        lblDeposite.setBounds(35, 430, 200, 14);
        frame.add(lblDeposite);

        JLabel l5 = new JLabel();
        l5.setBounds(271, 430, 200, 14);
        l5.setForeground(Color.RED);
        frame.add(l5);

        try{

            Connection dc = Database_Connection.getConnection();
            PreparedStatement ps = dc.prepareStatement("select * from customer where username=?");
            ps.setString(1,username);

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                l2.setText(rs.getString("id_name"));
                l3.setText(rs.getString("id_number"));
                l4.setText(rs.getString("phone"));
            }
        }catch(Exception e){e.printStackTrace();}

        JButton b1 = new JButton("Check Price");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String s1 = c1.getSelectedItem();
                    Connection dc = Database_Connection.getConnection();
                    PreparedStatement ps = dc.prepareStatement("select * from hotels where name=?");
                    ps.setString(1,s1);

                    ResultSet rs = ps.executeQuery();

                    if(rs.next())
                    {

                        int cost = Integer.parseInt(rs.getString("cost_per_day"));
                        int food = Integer.parseInt(rs.getString("food_charges"));
                        int ac = Integer.parseInt(rs.getString("ac_charges"));

                        int persons = Integer.parseInt(t1.getText());
                        int days = Integer.parseInt(t2.getText());

                        String acprice = c2.getSelectedItem();
                        String foodprice = c3.getSelectedItem();


                        if(persons * days > 0) {
                            int total = 0;
                            total += acprice.equals("AC") ? ac : 1;
                            total += foodprice.equals("Yes") ? food : 1;
                            total += cost;
                            total = total * persons * days;
                            l5.setText("Rs "+total);
                        }
                    }
                }catch(Exception ee){
                    System.out.println(ee.getMessage());
                }
            }
        });
        b1.setBounds(50, 470, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        frame.add(b1);


        JButton btnNewButton = new JButton("Book");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try{
                    Connection dc = Database_Connection.getConnection();
                    PreparedStatement ps = dc.prepareStatement("insert into bookhotel(username,hotel,rooms,days,ac,food,id,number,phone,price) values(?,?,?,?,?,?,?,?,?,?)");

                    ps.setString(1,l1.getText());
                    ps.setString(2,c1.getSelectedItem());
                    ps.setString(3,t1.getText());
                    ps.setString(4,t2.getText());
                    ps.setString(5,c2.getSelectedItem());
                    ps.setString(6,c3.getSelectedItem());
                    ps.setString(7,l2.getText());
                    ps.setString(8,l3.getText());
                    ps.setString(9,l4.getText());
                    ps.setString(10,l5.getText());

                    int i = ps.executeUpdate();
                    if (i>0)
                    {
                        JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                        frame.setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "try again later.");
                        frame.setVisible(false);
                    }
                }catch(Exception ee){
                    System.out.println(ee.getMessage());
                }

            }
        });
        btnNewButton.setBounds(200, 470, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        frame.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        btnExit.setBounds(350, 470, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        frame.add(btnExit);

        frame.setVisible(true);
    }
}