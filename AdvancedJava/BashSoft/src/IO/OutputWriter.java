package IO;

import java.util.ArrayList;

public class OutputWriter {
    public static void writeMessage(String message) {
        System.out.print(message);
    }

    public static void writeMessageOnNewLine(String message) {
        System.out.println(message);
    }

    public static void writeNewLine() {
        System.out.println();
    }

    public static void displayException(String message) {
        System.out.print(message);
    }

    public static void printStudent(String name , ArrayList<Integer> marks){
        String output = String.format("%s - %s",name , marks.toString());
        OutputWriter.writeMessageOnNewLine(output);
    }

}
