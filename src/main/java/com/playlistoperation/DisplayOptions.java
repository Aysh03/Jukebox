package com.playlistoperation;
import com.audio.SelectionByArtist;
import com.audio.SelectionByGenre;
import com.audio.SelectionBySongID;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import static com.audio.SongNameByAlphabet.SortSongNameByAlphabet;
import static com.playlistoperation.AddingSongAndPlaylist.*;
public class DisplayOptions
{
    public static void displayOption() throws SQLException, ClassNotFoundException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        Scanner scanner = new Scanner(System.in);
        int exit = 8;

            while (exit !=9) {
                System.out.println("Press 1 for Displaying Songs List ");
                System.out.println("Press 2 for Create PlayList ");
                System.out.println("Press 3 for Existing Playlist");
                System.out.println("Press 4 for Playing Song within Playlist");
                System.out.println("Press 5 for Playing Song by Genre");
                System.out.println("Press 6 for Playing Song by Artist");
                System.out.println("Press 7 for Viewing Alphabetically Ordered Songs List and playing song");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        displaySongList();
                        break;

                    case 2:
                        displaySongList();
                        createNewPlayList();
                        break;

                    case 3:
                        displayPlayList();
                        break;

                    case 4:
                    {
                        displayPlayList();
                        try {
                            System.out.println("Enter the Song ID you wish to play");
                            int opt = scanner.nextInt();
                            SelectionBySongID.selectAudio(opt);
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println(e);
                            displayOption();

                        }
                        break;
                    }
                    case 5:
                    {
                        displaySongList();
                        System.out.println("Enter the genre name you wish to play");
                        String opt=scanner.next();
                        SelectionByGenre.selectGenre(opt);
                        System.out.println("Enter the Song ID you wish to play");
                        int id = scanner.nextInt();
                        SelectionBySongID.selectAudio(id);



                        break;

                    }
                    case 6:
                    {
                        displaySongList();
                        System.out.println("Enter the Artist name you wish to play");
                        String opt=scanner.nextLine();
                        opt=scanner.nextLine();
                        SelectionByArtist.selectArtist(opt);
                        System.out.println("Enter the Song ID you wish to play");
                        int id = scanner.nextInt();
                        SelectionBySongID.selectAudio(id);
                        break;
                    }

                    case 7:
                    {
                        scanner.nextLine();
                        System.out.println("This is a Alphabetically Sorted Song List");
                        SortSongNameByAlphabet();
                        try {
                            System.out.println("Enter the Song ID you wish to play");
                            int id = scanner.nextInt();
                            SelectionBySongID.selectAudio(id);
                        }
                         catch (InputMismatchException e)
                        {
                            System.out.println(e);
                            displayOption();
                        }
                        break;

                    }
                        default:
                        System.out.println("Provide a valid option 1 or 2 or 3 or 4 ");
                        break;
                }
                System.out.println("Press 8 to continue");
                System.out.println("Press 9 to exit");
                int loop= scanner.nextInt();
                if (loop == 8)
                {
                   continue;
                }
                if (loop == 9)

                 break;

            }

                System.out.println("Thank you for using the JukeBox");
        }

}
