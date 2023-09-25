package com.management.travel_tourism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookPackage
{
    private JFrame frame;
    JTextField t1,t2;
    Choice c1,c2,c3;
    BookPackage(String username)
    {
        System.out.println(username);
        frame = new JFrame("BookPackage");
        frame.setBounds(420,220,1100,450);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setUndecorated(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./com/management/travel_tourism/icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel la1 = new JLabel(i3);
        la1.setBounds(450,50,700,300);
        frame.add(la1);

        JLabel lblName = new JLabel("BOOK PACKAGE");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(118, 11, 300, 53);
        frame.add(lblName);

        JLabel la2 = new JLabel("Username :");
        la2.setBounds(35, 70, 200, 14);
        frame.add(la2);

        JLabel l1 = new JLabel(username);
        l1.setBounds(271, 70, 200, 14);
        frame.add(l1);

        JLabel lblId = new JLabel("Select Package :");
        lblId.setBounds(35, 110, 200, 14);
        frame.add(lblId);

        c1 = new Choice();
        c1.add("Gold Package");
        c1.add("Silver Package");
        c1.add("Bronze Package");
        c1.setBounds(271, 110, 150, 30);
        frame.add(c1);

        JLabel la3 = new JLabel("Total Persons");
        la3.setBounds(35, 150, 200, 14);
        frame.add(la3);

        t1 = new JTextField();
        t1.setText("0");
        t1.setBounds(271, 150, 150, 20);
        frame.add(t1);
        t1.setColumns(10);

        JLabel lbl1 = new JLabel("ID :");
        lbl1.setBounds(35, 190, 200, 14);
        frame.add(lbl1);

        JLabel l2 = new JLabel();
        l2.setBounds(271, 190, 200, 14);
        frame.add(l2);

        JLabel lbl2 = new JLabel("Number :");
        lbl2.setBounds(35, 230, 200, 14);
        frame.add(lbl2);

        JLabel l3 = new JLabel();
        l3.setBounds(271, 230, 200, 14);
        frame.add(l3);

        JLabel lbl3 = new JLabel("Phone :");
        lbl3.setBounds(35, 270, 200, 14);
        frame.add(lbl3);

        JLabel l4 = new JLabel();
        l4.setBounds(271, 270, 200, 14);
        frame.add(l4);


        JLabel lblDeposite = new JLabel("Total Price :");
        lblDeposite.setBounds(35, 310, 200, 14);
        frame.add(lblDeposite);

        JLabel l5 = new JLabel();
        l5.setBounds(271, 310, 200, 14);
        l5.setForeground(Color.RED);
        frame.add(l5);

        try{
            Connection c = Database_Connection.getConnection();
            PreparedStatement ps = c.prepareStatement("select * from customer where username=?");
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                l2.setText(rs.getString("id_name"));
                l3.setText(rs.getString("id_number"));
                l4.setText(rs.getString("phone"));

            }

            rs.close();
        }
        catch(SQLException e){e.printStackTrace();}
        catch(Exception e){e.printStackTrace();}

        JButton b1 = new JButton("Check Price");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String p = c1.getSelectedItem();
                int cost = 0;
                if(p.equals("Gold Package")) {
                    cost += 12000;
                }if(p.equals("Silver Package")){
                    cost += 25000;
                }else if(p.equals("Bronze Package")){
                    cost += 32000;
                }

                cost *= Integer.parseInt(t1.getText());
                l5.setText("Rs "+cost);

            }
        });
        b1.setBounds(50, 350, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        frame.add(b1);


        JButton btnNewButton = new JButton("Book");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    Connection c = Database_Connection.getConnection();

                    String s1 = c1.getSelectedItem();
                    String q1 = "insert into bookpackage(username,package,persons,id_name,id_number,phone,price) values('"+username+"', '"+c1.getSelectedItem()+"', '"+t1.getText()+"', '"+l2.getText()+"', '"+l3.getText()+"', '"+l4.getText()+"', '"+l5.getText()+"')";

                    PreparedStatement ps = c.prepareStatement(q1);
                    int i = ps.executeUpdate();

                    if (i>0)
                    {
                        JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                        frame.setVisible(false);
                    }
                    if (i<=0)
                    {
                        JOptionPane.showMessageDialog(null, "Sorry Try again");
                    }
                }catch(Exception ee){
                    System.out.println(ee.getMessage());
                }

            }
        });
        btnNewButton.setBounds(200, 350, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        frame.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        btnExit.setBounds(350, 350, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        frame.add(btnExit);

        frame.setVisible(true);

    }
}
