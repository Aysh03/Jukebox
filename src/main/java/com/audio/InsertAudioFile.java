package com.audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
public class InsertAudioFile
{
        public static void playTheSong(String filepath) throws IOException, LineUnavailableException, UnsupportedAudioFileException, SQLException, ClassNotFoundException
        {
            Scanner sc=new Scanner(System.in);
            File file = new File(filepath);
            Clip clip = AudioSystem.getClip();  //The clip is preloading audio data lines prior to playback
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip.open(audioStream);
            int choice;
            int run = 0;
            long postionOfTheClip = 0;
            while (run == 0)
            {
                System.out.println("\n Enter Your Choice\n----- ---- ------\n " +
                        "1. Play\n 2. Pause\n 3. Resume\n 4. Restart\n 5. Forward\n 6.Backwards\n  9. Exit");

                choice = sc.nextInt();
                switch (choice)
                {
                    case 1:
                        clip.start();
                        System.out.println("+------------+");
                        System.out.println("|Playing Song|");
                        System.out.println("+------------+");
                        break;
                    case 2:
                        postionOfTheClip = clip.getMicrosecondPosition();
                        clip.stop();
                        System.out.println("+-----------+");
                        System.out.println("|Song Paused|");
                        System.out.println("+-----------+");
                        break;
                    case 3:
                        clip.setMicrosecondPosition(postionOfTheClip);
                        clip.start();
                        System.out.println("+------------+");
                        System.out.println("|Song Resumed|");
                        System.out.println("+------------+");
                        break;
                    case 4:
                        clip.setMicrosecondPosition(0);
                        clip.start();
                        System.out.println("+--------------+");
                        System.out.println("|Song Restarted|");
                        System.out.println("+--------------+");
                        break;
                    case 5:
                        System.out.println("+-----------------+");
                        System.out.println("|Forwarding by 30s|");
                        System.out.println("+-----------------+");
                        clip.setMicrosecondPosition(clip.getMicrosecondPosition() + 18000000);
                        break;
                    case 6:
                        System.out.println("+-----------------+");
                        System.out.println("|Backward by 30s|");
                        System.out.println("+-----------------+");
                        clip.setMicrosecondPosition(clip.getMicrosecondPosition() - 18000000);
                        break;
                    case 9:
                        clip.close();
                        run = 1;
                        break;
                    default:
                        System.out.println("Not a valid Input");
                }
            }
        }
    }
