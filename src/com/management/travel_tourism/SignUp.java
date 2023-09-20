package com.management.travel_tourism;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class SignUp
{
    private JFrame frame;
    SignUp()
    {
        Color color = new Color(131, 193, 233);

        frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(900,370);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setResizable(false);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(color);
        p1.setBounds(0,0,500,370);
        frame.add(p1);

        int l_x = 30;
        int l_width = 140;
        int l_height = 25;

        int t_x = 190;
        int t_width = 250;
        int t_height = 25;

        Font font = new Font("Arial",Font.BOLD,17);

        JLabel userL = new JLabel("Username");
        userL.setBounds(l_x,20,l_width,l_height);
        userL.setFont(font);
        p1.add(userL);
        JTextField userT = new JTextField();
        userT.setBounds(t_x,20,t_width,t_height);
        userT.setBorder(BorderFactory.createEmptyBorder());
        p1.add(userT);

        JLabel nameL = new JLabel("Name");
        nameL.setBounds(l_x,60,l_width,l_height);
        nameL.setFont(font);
        p1.add(nameL);
        JTextField nameT = new JTextField();
        nameT.setBounds(t_x,60,t_width,t_height);
        nameT.setBorder(BorderFactory.createEmptyBorder());
        p1.add(nameT);

        JLabel passL = new JLabel("Password");
        passL.setBounds(l_x,100,l_width,l_height);
        passL.setFont(font);
        p1.add(passL);
        JTextField passT = new JTextField();
        passT.setBounds(t_x,100,t_width,t_height);
        passT.setBorder(BorderFactory.createEmptyBorder());
        p1.add(passT);

        JLabel sqL = new JLabel("Security Question");
        sqL.setBounds(l_x,140,l_width,l_height);
        sqL.setFont(font);
        p1.add(sqL);
        String [] sec_arr = {"first school name","Friend name","car name", "favourite place name","movie name", "favourite DADDY name", "favourite MOMMY name"};
        JComboBox sqCB = new JComboBox(sec_arr);
        sqCB.setBounds(t_x,140,t_width,t_height);
        sqCB.setBorder(BorderFactory.createEmptyBorder());
        p1.add(sqCB);

        JLabel ansL = new JLabel("Answer");
        ansL.setBounds(l_x,180,l_width,l_height);
        ansL.setFont(font);
        p1.add(ansL);
        JTextField ansT = new JTextField();
        ansT.setBounds(t_x,180,t_width,t_height);
        ansT.setBorder(BorderFactory.createEmptyBorder());
        p1.add(ansT);

        JButton create_btn = new JButton("Create");
        create_btn.setBounds(90,260,120,30);
        create_btn.setBackground(Color.white);
        create_btn.setForeground(color);
        create_btn.setFont(new Font("Arial",Font.BOLD,15));
        p1.add(create_btn);
        create_btn.addActionListener(
                (e) ->
                {
                    String user = userT.getText();
                    String name = nameT.getText();
                    String pass = passT.getText();
                    String sec_ques = (String) sqCB.getSelectedItem();
                    String ans = ansT.getText();

                    dbConn(user,name,pass,sec_ques,ans);
                }
        );

        JButton back_btn = new JButton("Back");
        back_btn.setBounds(270,260,120,30);
        back_btn.setBackground(Color.white);
        back_btn.setForeground(color);
        back_btn.setFont(new Font("Arial",Font.BOLD,15));
        p1.add(back_btn);
        back_btn.addActionListener(
                (e) ->
                {
                    frame.setVisible(false);
                    new Login();
                }
        );

        JPanel p2 = new JPanel();
        p2.setBounds(500,0,400,370);
        p2.setLayout(null);
        frame.add(p2);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("managementsystem/Travel_Tourism/icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(100,60,200,200);
        p2.add(l1);

        frame.setVisible(true);
    }

    private void dbConn(String user, String name, String pass, String sec_ques, String ans)
    {
        try
            (
                    Connection dc = Database_Connection.getConnection();
                    PreparedStatement ps = dc.prepareStatement("insert into travel_tourism_signup(user,name,pass,sec_ques,ans) values(?,?,?,?,?)");
            )
        {
            ps.setString(1,user);
            ps.setString(2,name);
            ps.setString(3,pass);
            ps.setString(4,sec_ques);
            ps.setString(5,ans);
            int i = ps.executeUpdate();

            if (i>0)
            {
                JOptionPane.showMessageDialog(null,"Account Created");
                frame.setVisible(false);
                new Login();
            }
            else {JOptionPane.showMessageDialog(null,"try later...");}
        }
        catch (Exception e) {JOptionPane.showMessageDialog(null,"username is already present. please enter different username.");}
    }



    public static void main(String[] args)
    {
        new SignUp();
    }
}
