package onlineRadio.exceptions;

public class InvalidSongSecondsException extends InvalidSongLengthException {
        public InvalidSongSecondsException(){
            super("Song seconds should be between 0 and 59.");
        }
}
