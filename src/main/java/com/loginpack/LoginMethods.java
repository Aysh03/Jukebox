package com.loginpack;

import java.sql.SQLException;

public interface LoginMethods
{
    public  void createTable()throws SQLException,ClassNotFoundException;
    public void insertInTable(String EmailID, String firstName,String lastName,long mobileNumber,String password)throws SQLException,ClassNotFoundException;
}
