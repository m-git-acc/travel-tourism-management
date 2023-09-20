package com.management.travel_tourism;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database_Connection
{
    private static Connection con;
    public static Connection getConnection()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///core_projects","root","mohit123");
        }

        catch (Exception e) {e.printStackTrace();}

        return  con;
    }
}
