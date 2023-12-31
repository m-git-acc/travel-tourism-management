package com.management.travel_tourism;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paytm extends JFrame
{
    Paytm(){
        JEditorPane j = new JEditorPane();
        j.setEditable(false);

        try {
            j.setPage("https://www.paytm.com");
        }catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not load</html>");
        }

        JScrollPane scrollPane = new JScrollPane(j);
        getContentPane().add(scrollPane);
        setPreferredSize(new Dimension(800,600));

        JButton back=new JButton("Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        back.setBounds(610, 20, 80, 40);
        j.add(back);

        setSize(800,600);
        setLocation(600,220);
        setVisible(true);
    }
}