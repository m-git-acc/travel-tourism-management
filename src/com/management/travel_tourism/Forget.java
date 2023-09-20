package com.management.travel_tourism;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Forget
{
    private JTextField passT, secquesT, nameT, ansT;
    Forget()
    {
        JFrame frame = new JFrame("Forget Password");
        frame.setLayout(null);
        frame.setSize(900,400);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(20,20,500,320);
        p1.setBackground(new Color(133,193,233));
        frame.add(p1);

        int l_x = 20;
        int l_width = 80;
        int l_height = 20;
        int t_x = 120;
        int t_width = 200;
        int t_height = 20;

        Font font = new Font("Arial",Font.BOLD,15);
        Color color1 =  new Color(124, 142, 149);
        Color color2 = new Color(226, 231, 236);

        JLabel userL = new JLabel("Username");
        userL.setBounds(l_x,20,l_width,l_height);
        userL.setFont(font);
        p1.add(userL);
        JTextField userT = new JTextField();
        userT.setBounds(t_x,20,t_width,t_height);
        userT.setBorder(BorderFactory.createEmptyBorder());
        userT.setBackground(color2);
        p1.add(userT);

        JLabel nameL = new JLabel("Name");
        nameL.setBounds(l_x,60,l_width,l_height);
        nameL.setFont(font);
        p1.add(nameL);
        nameT = new JTextField();
        nameT.setBounds(t_x,60,t_width,t_height);
        nameT.setEditable(false);
        nameT.setBorder(BorderFactory.createEmptyBorder());
        nameT.setForeground(Color.WHITE);
        nameT.setBackground(color1);
        p1.add(nameT);

        JButton search_btn = new JButton("Search");
        search_btn.setBounds(370,30,120,40);
        search_btn.setBorder(BorderFactory.createEmptyBorder());
        search_btn.setBackground(new Color(81, 81, 81));
        search_btn.setForeground(new Color(223, 223, 223));
        search_btn.setFont(new Font("Arial",Font.TRUETYPE_FONT,20));
        p1.add(search_btn);
        search_btn.addActionListener(e->dbSearch(userT.getText()));

        JLabel secquesL = new JLabel("Security Question");
        secquesL.setBounds(l_x,100,l_width,l_height);
        secquesL.setFont(font);
        p1.add(secquesL);
        secquesT = new JTextField();
        secquesT.setBounds(t_x,100,300,t_height);
        secquesT.setBorder(BorderFactory.createEmptyBorder());
        secquesT.setForeground(Color.WHITE);
        secquesT.setEditable(false);
        secquesT.setBackground(color1);
        p1.add(secquesT);

        JLabel ansL= new JLabel("Answer");
        ansL.setBounds(l_x,140,l_width,l_height);
        ansL.setFont(font);
        p1.add(ansL);
        ansT = new JTextField();
        ansT.setBounds(t_x,140,t_width,t_height);
        ansT.setBorder(BorderFactory.createEmptyBorder());
        ansT.setBackground(color2);
        p1.add(ansT);

        JLabel passL= new JLabel("Password");
        passL.setBounds(l_x,180,l_width,l_height);
        passL.setFont(font);
        p1.add(passL);
        passT = new JTextField();
        passT.setBounds(t_x,180,t_width,t_height);
        passT.setBorder(BorderFactory.createEmptyBorder());
        passT.setEditable(false);
        passT.setBackground(color1);
        passT.setForeground(Color.WHITE);
        p1.add(passT);

        JButton retrieve_btn = new JButton("Retrieve");
        retrieve_btn.setBounds(370,150,120,40);
        retrieve_btn.setBorder(BorderFactory.createEmptyBorder());
        retrieve_btn.setBackground(new Color(81, 81, 81));
        retrieve_btn.setForeground(new Color(223, 223, 223));
        retrieve_btn.setFont(new Font("Arial",Font.TRUETYPE_FONT,20));
        p1.add(retrieve_btn);
        retrieve_btn.addActionListener(e-> dbRetrieve(userT.getText()));

        JButton back_btn = new JButton("Back");
        back_btn.setBounds(120,260,120,40);
        back_btn.setBorder(BorderFactory.createEmptyBorder());
        back_btn.setBackground(new Color(81, 81, 81));
        back_btn.setForeground(new Color(223, 223, 223));
        back_btn.setFont(new Font("Arial",Font.TRUETYPE_FONT,20));
        p1.add(back_btn);
        back_btn.addActionListener(
                e->
                {
                    frame.setVisible(false);
                    new Login();
                }
        );

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.white);
        p2.setBounds(520,20,380,360);
        frame.add(p2);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("managementsystem/Travel_Tourism/icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(30,20,300,300);
        p2.add(l1);

        frame.setVisible(true);
    }
    private void dbSearch(String user)
    {
        try(
                Connection dc = Database_Connection.getConnection();
                PreparedStatement ps = dc.prepareStatement("Select name,sec_ques from travel_tourism_signup WHERE user=?");
            )
        {
            ps.setString(1,user);

            try(ResultSet rs = ps.executeQuery();)
            {
                while (rs.next())
                {
                    nameT.setText(rs.getString("name"));
                    secquesT.setText(rs.getString("sec_ques"));
                }
            }
            catch (Exception e) {e.printStackTrace();}
        }
        catch (Exception e) {e.printStackTrace();}
    }
    private void dbRetrieve(String user)
    {
        try(
                Connection con = Database_Connection.getConnection();
                PreparedStatement ps = con.prepareStatement("select ans from travel_tourism_signup WHERE user=?");
            )
        {
            ps.setString(1,user);

            try(ResultSet rs = ps.executeQuery();)
            {
                if (rs.next())
                {
                    String db_ans = rs.getString("ans");
                    if (ansT.getText().equals(db_ans)) passSetter(user);
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Answer is wrong, please try again");
                        ansT.setText("");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"please fill Username first");
                    ansT.setText("");
                }

            }
            catch (Exception e) {e.printStackTrace();}
        }
        catch (Exception e) {e.printStackTrace();}
    }
    private void passSetter(String user)
    {
        try(
                Connection dc = Database_Connection.getConnection();
                PreparedStatement ps = dc.prepareStatement("select pass from travel_tourism_signup WHERE user=?");
                )
        {
            ps.setString(1,user);

            try(ResultSet rs = ps.executeQuery();)
            {
                while (rs.next()) {passT.setText(rs.getString("pass"));}
            }
            catch (Exception e) {e.printStackTrace();}
        }
        catch (Exception e) {e.printStackTrace();}
    }

    public static void main(String[] args) {
        new Forget();
    }
}
