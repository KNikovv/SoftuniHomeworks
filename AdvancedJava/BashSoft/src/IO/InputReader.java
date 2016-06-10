package IO;

import StaticData.SessionData;

import java.util.Scanner;

public class InputReader {
    private static final String endCommand = "quit";

    public static void readCommands() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            OutputWriter.writeMessage(String.format("%s > ", SessionData.currentPath));
            String input = scan.nextLine().trim();
            if(input.equals(endCommand)){
                break;
            }
            CommandInterpreter.interpretCommand(input);

        }
    }
}
