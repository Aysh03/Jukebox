package com.playlistoperation;

import com.loginpack.LoginConnectionDB;
import com.loginpack.LoginForum;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class AddingSongAndPlaylist
{
    public static String playListName="";
    public static void displaySongList() throws SQLException, ClassNotFoundException
    {
        Statement st= LoginConnectionDB.connection();
        ResultSet resultSet=st.executeQuery("select SongsID,Artist,Genre,SongsName,Duration from songsList");
        while(resultSet.next())
        {
            System.out.format("Song Id::%d , Artist Name:: %s , Genre:: %s ,SongsName::%s , Duration::%s "
                    ,resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),
                    resultSet.getString(4),resultSet.getString(5));
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------------------");
        }
    }
    public static void createNewPlayList() throws SQLException, ClassNotFoundException
    {
        Scanner scan=new Scanner(System.in);
        Statement state= LoginConnectionDB.connection();
        //scan.next();
        System.out.println("Enter the playlist name you want to create");
        playListName+=scan.nextLine();
        int exit=0;
        while (exit!=1)
        {

            System.out.println("Enter the song ID to into your playlist");
            int songID=scan.nextInt();
            int rows=0;
            ResultSet rS=state.executeQuery("select * from MainPlaylist  where SongsID ='"+songID+"' and  playListName='"+playListName+"'");
            if (rS.next())
            {
                System.out.println("This song is already added to the playlist");
            }
            else
                rows =state.executeUpdate("insert into MainPlaylist(playlistName,songsID,EmailID)  values('"+playListName+"','"+songID+"','"+ LoginForum.EmailID +"')");
            if (rows>0)
            {
                System.out.println("You Have Added a song into the playlist");
            }
//
            System.out.println("Enter 1 to continue adding song to playlist ");
            System.out.println("Enter 0 to stop adding songs to playlist ");
            int continuee=scan.nextInt();
            switch (continuee)
            {
                case 1:
                    System.out.println("You can add more songs to playlist");
                    break;
                case 0:
                    System.out.println("You have added all your favorites songs to the playlist");
                    exit++;
                    break;
                default:
                    System.out.println("Provide a valid input 1 or 0");
            }
        }
    }
    public static void displayPlayList() throws SQLException, ClassNotFoundException
    {
        System.out.println("Here is the list of Playlist");
        Scanner scan=new Scanner(System.in);

        Statement state= LoginConnectionDB.connection();
        ResultSet resultSet=state.executeQuery("select *  from MainPlaylist where EmailID = '"+ LoginForum.EmailID +"'");
        while(resultSet.next()) {
            System.out.format("Playlist ID:- %d , Playlist Name:: %s ,Song ID %d", resultSet.getInt(1), resultSet.getString(2),resultSet.getInt(3));
            System.out.println("");
        }
    }


}
