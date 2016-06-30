package onlineRadio.main;

import onlineRadio.exceptions.InvalidSongException;
import onlineRadio.models.Playlist;
import onlineRadio.models.Song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, InvalidSongException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));


        Playlist playlist = new Playlist();

        int numberOfSongsToAdd = Integer.valueOf(buffReader.readLine());
        for (int i = 0; i < numberOfSongsToAdd; i++) {
            String[] input = buffReader.readLine().split(";");
            if (input.length < 3) {
                throw new InvalidSongException();
            }
            String artist = input[0];
            String songName = input[1];
            String totalTime = input[2];
            try {
                int indexOfSeparator = totalTime.indexOf(":");
                int minutes = Integer.valueOf(totalTime.substring(0, indexOfSeparator));
                int seconds = Integer.valueOf(totalTime.substring(indexOfSeparator + 1));
                Song song = new Song(artist, songName, minutes, seconds);
                playlist.addSong(song);
            } catch (InvalidSongException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid song length.");
            }
        }

        playlist.calculatePlayListLength();
        System.out.println(playlist);
    }
}

