package com.management.travel_tourism;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login
{
    private JTextField passTf, userTf;
    private JFrame frame;

    Login()
    {
        Color color = new Color(131, 193, 233);

        frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(900,400);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setResizable(false);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(color);
        p1.setBounds(0,0,400,400);
        frame.add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./com/management/travel_tourism/icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(100,100,200,200);
        p1.add(l1);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30, 450,300);
        frame.add(p2);

        int x = 80;
        int L_width = 150;
        int L_height = 20;
        int T_width = 280;
        int T_height = 30;

        JLabel userL = new JLabel("Username");
        userL.setBounds(x, 20, L_width, L_height);
        userL.setFont(new Font("Arial",Font.BOLD,20));
        p2.add(userL);
        userTf = new JTextField();
        userTf.setBounds(x, 50, T_width, T_height);
        userTf.setBackground(new Color(211, 223, 232));
        userTf.setBorder(BorderFactory.createEmptyBorder());
        userTf.setFont(new Font("Arial",Font.PLAIN,18));
        p2.add(userTf);

        JLabel passL = new JLabel("Password");
        passL.setBounds(x, 100, L_width, L_height);
        passL.setFont(new Font("Arial",Font.BOLD,20));
        p2.add(passL);
        passTf = new JTextField();
        passTf.setBounds(x, 130, T_width, T_height);
        passTf.setBackground(new Color(211, 223, 232));
        passTf.setBorder(BorderFactory.createEmptyBorder());
        passTf.setFont(new Font("Arial",Font.PLAIN,18));
        p2.add(passTf);

        LineBorder lineBorder = new LineBorder(new Color(133,193,233));

        JButton login_btn = new JButton("Login");
        login_btn.setBounds(x,210,110,30);
        login_btn.setBorder(lineBorder);
        login_btn.setBackground(color);
        login_btn.setForeground(Color.WHITE);
        p2.add(login_btn);
        login_btn.addActionListener((e) ->dbConn(userTf.getText(),passTf.getText()));

        JButton sign_btn = new JButton("Sign-Up");
        sign_btn.setBounds(230,210,110,30);
        sign_btn.setBorder(lineBorder);
        sign_btn.setBackground(color);
        sign_btn.setForeground(Color.WHITE);
        p2.add(sign_btn);
        sign_btn.addActionListener(
                (e)->
                {
                    frame.setVisible(false);
                    new SignUp();
                }
        );

        JButton forget_btn = new JButton("Forget Password");
        forget_btn.setBounds(100,260,200,30);
        forget_btn.setBorder(lineBorder);
        forget_btn.setBackground(color);
        forget_btn.setForeground(Color.WHITE);
        p2.add(forget_btn);
        forget_btn.addActionListener(
                (e)->
                {
                    frame.setVisible(false);
                    new Forget();
                }
        );


        JLabel trouble_l = new JLabel("trouble in Login");
        trouble_l.setBounds(305,265,200,10);

        trouble_l.setFont(new Font("Arial",3,12));
        trouble_l.setForeground(Color.RED);
        p2.add(trouble_l);

        frame.setVisible(true);
    }

    private void dbConn(String user, String pass)
    {
        try(
                Connection dc = Database_Connection.getConnection();
                PreparedStatement ps = dc.prepareStatement("select name from signup where user=? and pass=?");
            )
        {
            ps.setString(1, user);
            ps.setString(2,pass);

            try(ResultSet rs = ps.executeQuery();)
            {

                if (rs.next())
                {
                    frame.setVisible(false);
                    new Loading(rs.getString("name"), user);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"incorrect password.");
                    userTf.setText("");
                    passTf.setText("");
                }
            }
            catch (Exception e) {e.printStackTrace();}

        }
        catch (Exception e) {e.printStackTrace();}
    }
}
