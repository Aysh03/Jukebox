package com.audio;

import com.loginpack.LoginConnectionDB;
import com.loginpack.LoginForum;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import static com.audio.Songslist.Genre;
import static com.playlistoperation.DisplayOptions.displayOption;

public class SelectionByGenre
{


    public static void selectGenre(String genre) throws SQLException, ClassNotFoundException
    {

        Statement st= LoginConnectionDB.connection();
        ResultSet rS = st.executeQuery("select * from SongsList where Genre like'" +genre+ "'");
        while (rS.next())
        {
            System.out.println(rS.getInt(1) + " : " + rS.getString(4));
        }
    }
//        else
//        {
//            System.out.println("Kindly Enter a Genre Name in the List");
//            System.out.println("                                      ");
//            displayOption();
//        }


    }

