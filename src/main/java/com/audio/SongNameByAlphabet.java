package com.audio;

import com.loginpack.LoginConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class SongNameByAlphabet
{
   public static List<Songslist> sList=new ArrayList<>();
    public static List<Songslist> SortSongNameByAlphabet() throws SQLException, ClassNotFoundException {
        Statement st = LoginConnectionDB.connection();

        ResultSet resultSet = st.executeQuery("select SongsID, Artist, Genre, SongsName, SongsPath, Duration from SongsList");
        while (resultSet.next()) {
            Songslist songslist = new Songslist(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4), resultSet.getString(6), resultSet.getString(5));
            sList.add(songslist);
        }
        sList.sort(Comparator.comparing(o -> o.SongsName));
        Iterator<Songslist> itr = sList.iterator();
        while (itr.hasNext())
        {
            Songslist sL = itr.next();
            System.out.println("Songs ID:: " + sL.SongsID + "   Songs Name: " + sL.SongsName + "   Artist:: " + sL.Artist + "   Genre:: " + sL.Genre + "   Duration:: " + sL.Duration);
            System.out.println("--------------------------------------------------------------------------------------------------------");
        }
        return sList;
    }
}
