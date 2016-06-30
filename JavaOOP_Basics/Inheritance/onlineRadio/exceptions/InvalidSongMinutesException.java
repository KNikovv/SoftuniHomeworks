package onlineRadio.exceptions;

public class InvalidSongMinutesException extends InvalidSongLengthException {
        public InvalidSongMinutesException(){
            super("Song minutes should be between 0 and 14.");
        }
}
