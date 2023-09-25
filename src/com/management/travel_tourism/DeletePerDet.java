package com.management.travel_tourism;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeletePerDet
{
    private JFrame frame;
    private JTextField t_user,t_id,t_no,t_name,t_gender,t_country,t_addr,t_ph, t_mail;

    DeletePerDet(String user)
    {
        frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(820,500);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setResizable(false);
        frame.setUndecorated(true);

        JLabel h1 = new JLabel("DELETE CUSTOMER DETAILS");
        h1.setBounds(55,10,400,30);
        h1.setFont(new Font("Arial",Font.BOLD,20));
        frame.add(h1);

        int l_width = 100, l_height = 25, l_x = 30;
        int tf_width = 200, tf_height = 25, tf_x = 200;

        Font font_l = new Font("Arial",Font.BOLD,15 );
        Font font_t = new Font("Arial",Font.PLAIN,16 );

        JLabel l_user = new JLabel("Username : ");
        l_user.setBounds(l_x,60,l_width,l_height);
        l_user.setFont(font_l);
        frame.add(l_user);
        t_user = new JTextField();
        t_user.setBounds(tf_x,60,tf_width,tf_height);
        t_user.setEditable(false);
        t_user.setFont(font_t);
        frame.add(t_user);

        JLabel l_id = new JLabel("ID : ");
        l_id.setBounds(l_x,100,l_width,l_height);
        l_id.setFont(font_l);
        frame.add(l_id);
        t_id = new JTextField();
        t_id.setBounds(tf_x,100,tf_width,tf_height);
        t_id.setEditable(false);
        t_id.setFont(font_t);
        frame.add(t_id);

        JLabel l_no = new JLabel("ID Number : ");
        l_no.setBounds(l_x,140,l_width,l_height);
        l_no.setFont(font_l);
        frame.add(l_no);
        t_no = new JTextField();
        t_no.setBounds(tf_x,140,tf_width,tf_height);
        t_no.setEditable(false);
        t_no.setFont(font_t);
        frame.add(t_no);

        JLabel l_name = new JLabel("Name : ");
        l_name.setBounds(l_x,180,l_width,l_height);
        l_name.setFont(font_l);
        frame.add(l_name);
        t_name = new JTextField();
        t_name.setBounds(tf_x,180,tf_width,tf_height);
        t_name.setEditable(false);
        t_name.setFont(font_t);
        frame.add(t_name);

        JLabel l_gender = new JLabel("Gender : ");
        l_gender.setBounds(l_x,220,l_width,l_height);
        l_gender.setFont(font_l);
        frame.add(l_gender);
        t_gender = new JTextField();
        t_gender.setEditable(false);
        t_gender.setBounds(tf_x,220,tf_width,tf_height);
        t_gender.setFont(font_t);
        frame.add(t_gender);

        JLabel l_country= new JLabel("Country : ");
        l_country.setBounds(l_x,260,l_width,l_height);
        l_country.setFont(font_l);
        frame.add(l_country);
        t_country = new JTextField();
        t_country.setBounds(tf_x,260,tf_width,tf_height);
        t_country.setEditable(false);
        t_country.setFont(font_t);
        frame.add(t_country);

        JLabel l_addr = new JLabel("Address : ");
        l_addr.setBounds(l_x,300,l_width,l_height);
        l_addr.setFont(font_l);
        frame.add(l_addr);
        t_addr = new JTextField();
        t_addr.setBounds(tf_x,300,tf_width,tf_height);
        t_addr.setEditable(false);
        t_addr.setFont(font_t);
        frame.add(t_addr);

        JLabel l_ph= new JLabel("Phone : ");
        l_ph.setBounds(l_x,340,l_width,l_height);
        l_ph.setFont(font_l);
        frame.add(l_ph);
        t_ph = new JTextField();
        t_ph.setBounds(tf_x,340,tf_width,tf_height);
        t_ph.setEditable(false);
        t_ph.setFont(font_t);
        frame.add(t_ph);

        JLabel l_mail = new JLabel("Email : ");
        l_mail.setBounds(l_x,380,l_width,l_height);
        l_mail.setFont(font_l);
        frame.add(l_mail);
        t_mail = new JTextField();
        t_mail.setBounds(tf_x,380,tf_width,tf_height);
        t_mail.setEditable(false);
        t_mail.setFont(font_t);
        frame.add(t_mail);

        JButton b_delete = new JButton("Delete");
        b_delete.setBounds(50, 440, 130,25);
        b_delete.setFont(new Font("Tahoma",Font.BOLD,15));
        b_delete.setBackground(Color.BLACK);
        b_delete.setForeground(Color.WHITE);
        b_delete.addActionListener(e -> delete_db(user));
        frame.add(b_delete);

        JButton b_back = new JButton("Back");
        b_back.setBounds(230, 440, 130,25);
        b_back.setFont(new Font("Tahoma",Font.BOLD,15));
        b_back.setBackground(Color.BLACK);
        b_back.setForeground(Color.WHITE);
        frame.add(b_back);
        b_back.addActionListener(e -> {frame.setVisible(false);});

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./com/management/travel_tourism/icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(260,470,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(450,0,330,500);
        frame.add(l4);

        boolean b = true;
        try(
                Connection con = Database_Connection.getConnection();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM customer WHERE username=?")
            )
        {
            ps.setString(1,user);
            try(ResultSet rs = ps.executeQuery())
            {
                if (rs.next())
                {
                    t_name.setText(rs.getString("name"));
                    t_user.setText(rs.getString("username"));
                    t_id.setText(rs.getString("id_name"));
                    t_no.setText(rs.getString("id_number"));
                    t_gender.setText(rs.getString("gender"));
                    t_country.setText(rs.getString("country"));
                    t_addr.setText(rs.getString("address"));
                    t_ph.setText(rs.getString("phone"));
                    t_mail.setText(rs.getString("mail"));
                }
                else
                {
                    JOptionPane.showMessageDialog(frame,"You haven't created your Account yet.\nPlease create your account first");
                    b = false;
                }
            }
            catch (Exception e) {e.printStackTrace();}
        }
        catch (Exception e) {e.printStackTrace();}

        if (b) frame.setVisible(b);
    }
    private void delete_db(String user)
    {
        int x = JOptionPane.showConfirmDialog(null, "Do you want to delete your account?");
        if (x==0)
        {
            try
            {
                Connection con = Database_Connection.getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM customer WHERE username=?");

                ps.setString(1,user);
                int n = ps.executeUpdate();
                if (n>0)
                {
//                ====================================================================================================
                    try(PreparedStatement ps2 = con.prepareStatement("DELETE FROM signup WHERE user=?");)
                    {
                        ps2.setString(1,user);
                        ps2.executeUpdate();
                    }
                    catch (Exception e) {e.printStackTrace();}
                    try(PreparedStatement ps2 = con.prepareStatement("DELETE FROM bookpackage WHERE username=?");)
                    {
                        ps2.setString(1,user);
                        ps2.executeUpdate();
                    }
                    catch (Exception e) {e.printStackTrace();}
                    try(PreparedStatement ps2 = con.prepareStatement("DELETE FROM bookhotel WHERE username=?");)
                    {
                        ps2.setString(1,user);
                        ps2.executeUpdate();
                    }
                    catch (Exception e) {e.printStackTrace();}
//                ==================================================================================================

                    JOptionPane.showMessageDialog(null, "Your Account is deleted successfully....");
                    System.exit(0);
                }
                else JOptionPane.showMessageDialog(null,"please create your account first..");

            }
            catch (Exception e) {e.printStackTrace();}
        }
        else if(x==1)
        {
            frame.setVisible(false);
        }
    }
}