package com.management.travel_tourism;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewDetails
{
    ViewDetails(String username)
    {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(1000,550);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.white);
        frame.setDefaultCloseOperation(3);

        Font l_font = new Font("Raleway",Font.BOLD, 20);
        Font t_font = new Font("Arial",Font.PLAIN,16);

        int l_x=30, l_width=150, l_height=25;
        int t_x=220, t_width=230, t_height=20;

        String [] l_names = {"Username :", "ID : ","Number : ","Name : ", "Gender : "};
        JLabel [] left_side = new JLabel[5];
        int n = 15;
        for (int i = 0; i<=4; i++, n+=50)
        {
            left_side[i] = new JLabel(l_names[i]);
            left_side[i].setBounds(l_x,n,l_width,l_height);
            left_side[i].setFont(l_font);
            frame.add(left_side[i]);
        }

        JLabel [] right_side = new JLabel[5];
        int r = 18;
        for (int i = 0; i<=4; i++, r+=50)
        {
            right_side[i] = new JLabel();
            right_side[i].setBounds(t_x,r,t_width,t_height);
            right_side[i].setFont(t_font);
            frame.add(right_side[i]);
        }

        int l_x2=530, l_width2=150, l_height2=25;
        int t_x2=720, t_width2=230, t_height2=20;
        String [] l_names2 = {"Country : ","Address : ", "Phone : ","Email :"};
        JLabel [] left_side2 = new JLabel[4];
        int n2 = 15;
        for (int i = 0; i<=3; i++, n2+=50)
        {
            left_side2[i] = new JLabel(l_names2[i]);
            left_side2[i].setBounds(l_x2,n2,l_width2,l_height2);
            left_side2[i].setFont(l_font);
            frame.add(left_side2[i]);
        }

        JLabel [] right_side2 = new JLabel[4];
        int r2 = 18;
        for (int i = 0; i<=3; i++, r2+=50)
        {
            right_side2[i] = new JLabel();
            right_side2[i].setBounds(t_x2,r2,t_width2,t_height2);
            right_side2[i].setFont(t_font);
            frame.add(right_side2[i]);
        }

        JButton back = new JButton("B A C K");
        back.setBounds(400,280,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        frame.add(back);
        back.addActionListener(e -> {frame.setVisible(false);});

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("managementsystem/Travel_Tourism/icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000,250,Image.SCALE_REPLICATE);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imageicon = new JLabel(i3);
        imageicon.setBounds(0,330,1000,250);
        frame.add(imageicon);

        try(
                Connection con = Database_Connection.getConnection();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM travel_tourism_customer WHERE username=?");
            )
        {
            ps.setString(1,username);

            try(ResultSet rs = ps.executeQuery();)
            {
                if (rs.next())
                {
                    String user = rs.getString("username");
                    String  idname = rs.getString("id_name");
                    String  idno = rs.getString("id_number");
                    String  name = rs.getString("name");
                    String  gender = rs.getString("gender");
                    String  country = rs.getString("country");
                    String  addr = rs.getString("address");
                    String  ph = rs.getString("phone");
                    String  mail = rs.getString("mail");


                    String dbarr1 [] = {user,idname, idname, name,gender};
                    for (int i = 0; i<=4; i++) right_side[i].setText(dbarr1[i]);

                    String dbarr2 [] = {country,addr,ph,mail};
                    for (int i = 0; i<=3; i++) right_side2[i].setText(dbarr2[i]);
                }
                else JOptionPane.showMessageDialog(frame,"please create account first...");
            }
            catch (Exception e) {e.printStackTrace();}

        }
        catch (Exception e) {e.printStackTrace();}
        frame.setVisible(true);
    }
}
