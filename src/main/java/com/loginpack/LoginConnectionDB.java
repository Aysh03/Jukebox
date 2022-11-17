package com.loginpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginConnectionDB
{
    public static Statement connection() throws SQLException,ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jukeboxAyush","root","root@123");
        Statement statement=con.createStatement();
        return statement;



    }

}
