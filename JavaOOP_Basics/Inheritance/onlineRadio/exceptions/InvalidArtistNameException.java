package onlineRadio.exceptions;

public class InvalidArtistNameException extends InvalidSongException {

    public InvalidArtistNameException() {
        super("Artist name should be between 3 and 20 symbols.");
    }

}
