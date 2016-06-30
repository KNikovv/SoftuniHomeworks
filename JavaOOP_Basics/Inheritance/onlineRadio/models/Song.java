package onlineRadio.models;

import onlineRadio.exceptions.*;

public class Song {

    private String artistName;
    private String songName;
    private int songMinutes;
    private int songSeconds;

    public Song(String artistName, String songName, int songMinutes, int songSeconds) throws InvalidSongException {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setSongMinutes(songMinutes);
        this.setSongSeconds(songSeconds);
    }

    private String getArtistName() {
        return artistName;
    }

    private void setArtistName(String artistName) throws InvalidSongException {
        if (artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException();
        }
        this.artistName = artistName;
    }

    private String getSongName() {
        return songName;
    }

    private void setSongName(String songName) throws InvalidSongException {
        if(songName.length()<3||songName.length()>30){
            throw new InvalidSongNameException();
        }
        this.songName = songName;
    }

    public int getSongMinutes() {
        return songMinutes;
    }

    private void setSongMinutes(int songMinutes) throws InvalidSongLengthException {
        if(songMinutes<0||songMinutes>14){
            throw new InvalidSongMinutesException();
        }
        this.songMinutes = songMinutes;
    }

    public int getSongSeconds() {
        return songSeconds;
    }

    private void setSongSeconds(int songSeconds) throws InvalidSongLengthException {
        if(songSeconds<0||songSeconds>59){
            throw new InvalidSongSecondsException();
        }
        this.songSeconds = songSeconds;
    }
}
