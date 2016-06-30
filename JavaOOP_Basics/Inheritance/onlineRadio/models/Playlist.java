package onlineRadio.models;

import java.util.ArrayList;

public class Playlist {

    private ArrayList<Song> songs;
    private int playlistHours;
    private int playlistMinutes;
    private int playlistSeconds;

    public Playlist() {
        this.songs = new ArrayList<>();
    }

    public void calculatePlayListLength() {
        int totalSeconds = 0;
        for (Song song : this.songs) {
            totalSeconds += song.getSongSeconds();
            totalSeconds += song.getSongMinutes() * 60;
        }
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds / 60 )% 60;
        int seconds = totalSeconds % 60;

        this.playlistHours = hours;
        this.playlistMinutes = minutes;
        this.playlistSeconds = seconds;
    }

    public void addSong(Song song) {
        this.songs.add(song);
        System.out.println("Song added.");
    }

    @Override
    public String toString() {
        return String.format("Songs added: %d\nPlaylist length: %dh %dm %ds",
                this.songs.size(), this.playlistHours, this.playlistMinutes, this.playlistSeconds);
    }
}
