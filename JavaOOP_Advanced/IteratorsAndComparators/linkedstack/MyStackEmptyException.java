package lineardatastructures.linkedstack;

public class MyStackEmptyException extends RuntimeException {

    public MyStackEmptyException() {
        super("No elements");
    }
}
