package com.audio;

public class Songslist
{
    int SongsID;
     static String Artist;
     static String Genre;
    String SongsName;
     String Duration;
    String SongsPath;

    public Songslist(int songsID, String artist, String genre, String songsName, String duration, String songsPath)
    {
        SongsID = songsID;
        Artist = artist;
        Genre = genre;
        SongsName = songsName;
        Duration = duration;
        SongsPath = songsPath;
    }

    public String getSongsName() {
        return SongsName;
    }

    public void setSongsName(String songsName) {
        SongsName = songsName;
    }

    @Override
    public String toString()
    {
        return "Songslist{" +
                "SongsID=" + SongsID +
                ", Artist='" + Artist + '\'' +
                ", Genre='" + Genre + '\'' +
                ", SongsName='" + SongsName + '\'' +
                ", Duration='" + Duration + '\'' +
                ", SongsPath='" + SongsPath + '\'' +
                '}';
    }
}

