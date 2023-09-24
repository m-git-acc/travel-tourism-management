package com.management.travel_tourism;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database_Connection
{
    private static Connection con;
    public static Connection getConnection()
    {
        try{
            //calling the driver to use DATABASE
            Class.forName("com.mysql.cj.jdbc.Driver");

            //inserting the local database details.
            con = DriverManager.getConnection("jdbc:mysql:///travel_tourism_j2se","root","mohit123");
        }

        catch (Exception e) {e.printStackTrace();}

        return  con;
    }
}
