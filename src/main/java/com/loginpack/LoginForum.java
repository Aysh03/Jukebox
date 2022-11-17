package com.loginpack;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public  class LoginForum implements LoginMethods
{
    private String firstName;
    private String lastName;
    private long mobileNumber;
   public static String EmailID;
    private String password;




    public void screen() throws SQLException, ClassNotFoundException
    {

        System.out.println("--------------------------");
        System.out.println("Welcome to My Jukebox");
        System.out.println("--------------------------");
        System.out.println("                           ");
        System.out.println("If you are a existing user Press 1 ");
        System.out.println("If you are a new user for Registration press 2");
        try
        {
        Scanner scanner=new Scanner(System.in);

        int option=scanner.nextInt();

        switch (option)
        {
            case 1:
            {
                Statement state=LoginConnectionDB.connection();
                System.out.println("Enter your User Name/Email ID");
                EmailID=scanner.next();
                System.out.println("Enter your password");
                password=scanner.next();
                    ResultSet rs=state.executeQuery("select EmailID,password from Credentials where emailId='"+EmailID+"'and password='"+password+"' ");
                    if(rs.next())
                    {
                        String em=rs.getString(1);
                        String ps=rs.getString(2);
                        if(em.equalsIgnoreCase(EmailID)&& ps.equals(password))
                        {
                            LoginForum.EmailID=em;
                            System.out.println("----------------------------------------------");
                            System.out.println("You have  logged in Successfully       ");
                            System.out.println("----------------------------------------------");
                        }
                    }
                else
                {
                    System.out.println("Please enter valid credentials");
                    screen();
                }
                break;
            }
            case  2: {
                Statement state = LoginConnectionDB.connection();
                state.execute("create table if not exists Credentials(EmailID varchar(40),firstName varchar(30)," +
                        "lastName varchar(30),mobileNumber long,password varchar(40),constraint primary key(EmailID))");
                System.out.println("Enter your first name");
                firstName = scanner.next();
                System.out.println("Enter your last name");
                lastName = scanner.next();
                System.out.println("Enter your mobile number");
                mobileNumber = scanner.nextLong();
                System.out.println("Enter your Email ID");
                EmailID = scanner.next();
                System.out.println("Enter the password which should be alphanumeric");
                password = scanner.next();
                insertInTable(EmailID, firstName, lastName, mobileNumber, password);
            }
                break;

            default:
            {
                System.out.println("Enter a valid input");
                screen();
                break;
            }
        }

        }
        catch (InputMismatchException e)
        {
            System.out.println("Enter a valid input Please!");
            screen();
        }
    }

         @Override
            public void createTable() throws SQLException, ClassNotFoundException
         {
        Statement state=LoginConnectionDB.connection();
        boolean bs= state.execute("create table if not exists Credentials(EmailID varchar(40),firstName varchar(30)," +
                "lastName varchar(30),mobileNumber long,password varchar(40),constraint primary key(EmailID))");
    }

         @Override
        public void insertInTable(String EmailID, String firstName,String lastName,long mobileNumber,String password) throws SQLException, ClassNotFoundException
        {
        Statement state=LoginConnectionDB.connection();
        state.executeUpdate("insert into  Credentials values('"+EmailID+"','"+firstName+"'," +
                "'"+lastName+"','"+mobileNumber+"','"+password+"')");

        }
}
