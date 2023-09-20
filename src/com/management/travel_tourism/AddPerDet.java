package com.management.travel_tourism;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddPerDet
{
    private JFrame frame;
    private String id_Proof [] = {"Aadhar Card", "Passport", "Pan Card", "Driving Licence","Ration Card"};
    AddPerDet(String user, String name)
    {

        frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(820,500);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setResizable(false);
        frame.setUndecorated(true);

        JLabel h1 = new JLabel("ADD CUSTOMER DETAILS");
        h1.setBounds(75,10,400,30);
        h1.setFont(new Font("Arial",Font.BOLD,20));
        frame.add(h1);

        int l_width = 100, l_height = 25, l_x = 30;
        int tf_width = 200, tf_height = 23, tf_x = 200;

        Font font_l = new Font("Arial",Font.BOLD,15 );
        Font font_t = new Font("Arial",Font.PLAIN,15 );

        JLabel l_user = new JLabel("Username : ");
        l_user.setBounds(l_x,60,l_width,l_height);
        l_user.setFont(font_l);
        frame.add(l_user);
        JTextField t_user = new JTextField(user);
        t_user.setEditable(false);
        t_user.setBackground(Color.WHITE);
        t_user.setBounds(tf_x,60,tf_width,tf_height);
        t_user.setFont(font_t);
        frame.add(t_user);

        JLabel l_id = new JLabel("ID : ");
        l_id.setBounds(l_x,100,l_width,l_height);
        l_id.setFont(font_l);
        frame.add(l_id);
        JComboBox t_id = new JComboBox(id_Proof);
        t_id.setBounds(tf_x,100,tf_width,tf_height);
        t_id.setFont(font_t);
        frame.add(t_id);

        JLabel l_no = new JLabel("ID Number : ");
        l_no.setBounds(l_x,140,l_width,l_height);
        l_no.setFont(font_l);
        frame.add(l_no);
        JTextField t_no = new JTextField();
        t_no.setBounds(tf_x,140,tf_width,tf_height);
        t_no.setFont(font_t);
        frame.add(t_no);

        JLabel l_name = new JLabel("Name : ");
        l_name.setBounds(l_x,180,l_width,l_height);
        l_name.setFont(font_l);
        frame.add(l_name);
        JTextField t_name = new JTextField(name);
        t_name.setEditable(false);
        t_name.setBackground(Color.WHITE);
        t_name.setBounds(tf_x,180,tf_width,tf_height);
        t_name.setFont(font_t);
        frame.add(t_name);

        JLabel l_gender = new JLabel("Gender : ");
        l_gender.setBounds(l_x,220,l_width,l_height);
        l_gender.setFont(font_l);
        frame.add(l_gender);
        JRadioButton rd_male = new JRadioButton("Male");
        rd_male.setBounds((tf_x),220,(tf_width-100),(tf_height));
        rd_male.setBackground(Color.WHITE);
        rd_male.setFont(font_t);
        frame.add(rd_male);
        JRadioButton rd_female = new JRadioButton("Female");
        rd_female.setBounds((tf_x+100),220,(tf_width-100),(tf_height));
        rd_female.setBackground(Color.WHITE);
        rd_female.setFont(font_t);
        frame.add(rd_female);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rd_male);
        bg.add(rd_female);

        JLabel l_country= new JLabel("Country : ");
        l_country.setBounds(l_x,260,l_width,l_height);
        l_country.setFont(font_l);
        frame.add(l_country);
        JTextField t_country = new JTextField();
        t_country.setBounds(tf_x,260,tf_width,tf_height);
        t_country.setFont(font_t);
        frame.add(t_country);

        JLabel l_addr = new JLabel("Address : ");
        l_addr.setBounds(l_x,300,l_width,l_height);
        l_addr.setFont(font_l);
        frame.add(l_addr);
        JTextField t_addr = new JTextField();
        t_addr.setBounds(tf_x,300,tf_width,tf_height);
        t_addr.setFont(font_t);
        frame.add(t_addr);

        JLabel l_ph= new JLabel("Phone : ");
        l_ph.setBounds(l_x,340,l_width,l_height);
        l_ph.setFont(font_l);
        frame.add(l_ph);
        JTextField t_ph = new JTextField();
        t_ph.setBounds(tf_x,340,tf_width,tf_height);
        t_ph.setFont(font_t);
        frame.add(t_ph);

        JLabel l_mail = new JLabel("Email : ");
        l_mail.setBounds(l_x,380,l_width,l_height);
        l_mail.setFont(font_l);
        frame.add(l_mail);
        JTextField t_mail = new JTextField();
        t_mail.setBounds(tf_x,380,tf_width,tf_height);
        t_mail.setFont(font_t);
        frame.add(t_mail);

        JButton b_add = new JButton("Add");
        b_add.setBounds(50, 440, 130,25);
        b_add.setFont(new Font("Tahoma",Font.BOLD,15));
        b_add.setBackground(Color.BLACK);
        b_add.setForeground(Color.WHITE);
        b_add.addActionListener(e -> {
            String get_gender;
            if (rd_male.isSelected()) get_gender="Male";
            else get_gender = "Female";

            addCust(user,(String) t_id.getSelectedItem(),t_no.getText(),t_name.getText(),get_gender, t_country.getText(),t_addr.getText(), t_ph.getText(), t_mail.getText());
        });
        frame.add(b_add);

        JButton b_back = new JButton("Back");
        b_back.setBounds(230, 440, 130,25);
        b_back.setFont(new Font("Tahoma",Font.BOLD,15));
        b_back.setBackground(Color.BLACK);
        b_back.setForeground(Color.WHITE);
        frame.add(b_back);
        b_back.addActionListener(e -> {frame.setVisible(false);});

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("managementsystem/Travel_Tourism/icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(260,470,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(450,0,330,500);
        frame.add(l4);

//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    private void addCust(String user, String id, String id_num, String name, String gender, String country, String addr, String ph, String mail)
    {
        try
        {
            if (id_num.equalsIgnoreCase("") || country.equalsIgnoreCase("") || addr.equalsIgnoreCase("") || ph.equalsIgnoreCase("") || mail.equalsIgnoreCase(""))
            {
                throw new RuntimeException("Please Fill All Details");
            }

            else
            {
                try(
                        Connection con = Database_Connection.getConnection();
                        PreparedStatement ps = con.prepareStatement("INSERT INTO travel_tourism_customer(username, name, id_name, id_number, gender, country, address, phone, mail) VALUES(?,?,?,?,?,?,?,?,?) ");
                )
                {
                    ps.setString(1,user);
                    ps.setString(2,name);
                    ps.setString(3,id);
                    ps.setString(4,id_num);
                    ps.setString(5,gender);
                    ps.setString(6,country);
                    ps.setString(7,addr);
                    ps.setString(8,ph);
                    ps.setString(9,mail);


                    int i = ps.executeUpdate();
                    if (i>0)
                    {
                        JOptionPane.showMessageDialog(frame,"Customer Details Added Successfully...");
                        frame.setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(frame,"failed to add customer details...");
                    }
                }
                catch (Exception e) {JOptionPane.showMessageDialog(frame,e.getMessage());}
            }
        }
        catch (Exception e) {JOptionPane.showMessageDialog(frame,e.getMessage());}
    }
}
