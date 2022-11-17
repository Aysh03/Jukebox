package com.audio;

import com.loginpack.LoginConnectionDB;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import static com.audio.Songslist.Artist;

import static com.playlistoperation.DisplayOptions.displayOption;

public class SelectionByArtist
{
    public static void selectArtist(String artist) throws SQLException, ClassNotFoundException, UnsupportedAudioFileException, LineUnavailableException, IOException
    {
        Statement st = LoginConnectionDB.connection();

           ResultSet rS = st.executeQuery("select * from SongsList where Artist like'" + artist + "'");
           while (rS.next())
           {
               System.out.println(rS.getInt(1) + " : " + rS.getString(4));
           }

//        else
//        {
//            System.out.println("Kindly Enter a Artist Name in the List");
//            System.out.println("                                      ");
//            displayOption();
//       }
    }
}
