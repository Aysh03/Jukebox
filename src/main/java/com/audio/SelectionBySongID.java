package com.audio;

import com.loginpack.LoginConnectionDB;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;

import static com.audio.InsertAudioFile.playTheSong;

public class SelectionBySongID
{
   public static  String filepath;

        public static void selectAudio(int songsID) throws UnsupportedAudioFileException, SQLException, LineUnavailableException, IOException, ClassNotFoundException
        {
            try {
                    Statement st = LoginConnectionDB.connection();
                    ResultSet rS = st.executeQuery("Select * from SongsList where songsId= " + songsID + "");

                    if (rS.next())
                    {
                        filepath = rS.getString(5);
                        System.out.println(filepath);
                        playTheSong(filepath);
                    }
                    else
                    {
                        throw new SongsIdDoesnotExistException("Enter a valid Song ID");
                    }
                }
            catch (SongsIdDoesnotExistException e)
            {
                    System.out.println(e);
            }
        }
}
