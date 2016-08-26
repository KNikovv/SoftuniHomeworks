package logger.models.files;

public interface File {
    void write(String message);

    int getSize();
}
