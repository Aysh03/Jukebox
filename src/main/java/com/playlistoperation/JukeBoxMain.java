package com.playlistoperation;

import com.audio.SongsIdDoesnotExistException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;

import static com.audio.SongNameByAlphabet.SortSongNameByAlphabet;
import static com.playlistoperation.DisplayOptions.displayOption;
import static com.loginpack.LoginImpl.login;

public class JukeBoxMain
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException, UnsupportedAudioFileException, LineUnavailableException, IOException, SongsIdDoesnotExistException
    {
        login();
        displayOption();
    }

}
