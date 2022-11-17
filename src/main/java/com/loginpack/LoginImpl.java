package com.loginpack;

import com.audio.SongsIdDoesnotExistException;

import java.sql.SQLException;
import java.sql.Statement;

public class LoginImpl
{
      public static void login() throws SQLException, ClassNotFoundException, SongsIdDoesnotExistException {
          LoginForum lf = new LoginForum();
          lf.screen();
          lf.createTable();
      }

}

