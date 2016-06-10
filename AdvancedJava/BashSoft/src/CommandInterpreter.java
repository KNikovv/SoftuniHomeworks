import IO.IOManager;
import IO.OutputWriter;
import Judge.Tester;
import Repository.StudentRepository;
import StaticData.ExceptionMessages;
import StaticData.SessionData;

import java.awt.*;
import java.io.*;

public class CommandInterpreter {
    public static void interpretCommand(String input) {
        String[] data = input.split("\\s+");
        String command = data[0];

        switch (command) {
            case "open":
                tryOpenFile(input, data);
                break;
            case "mkdir":
                tryCreateDirectory(input, data);
                break;
            case "ls":
                tryTraverseFolder(input, data);
                break;
            case "cmp":
                tryCompareFiles(input, data);
                break;
            case "changeDirRel":
                tryChangeRelativePath(input, data);
                break;
            case "changeDirAbs":
                tryChangeAbsolutePath(input, data);
                break;
            case "readDb":
                tryReadDatabaseFromFile(input, data);
                break;
            case "filter":
                tryPrintFilteredStudents(input, data);
                break;
            case "order":
                tryPrintOrderedStudents(input, data);
                break;
            case "download":
            case "downloadAsynch":
            case "help":
                getHelp();
                break;
            case "show":
                tryShowWantedCourse(input, data);
                break;
            default:
                displayInvalidCommandMessage(input);
                break;
        }
    }

    private static void tryPrintFilteredStudents(String input, String[] data) {
        if (data.length != 3 && data.length != 4) {
            displayInvalidCommandMessage(input);
            return;
        }
        String course = data[1];
        String filter = data[2];
        if (data.length == 3) {
            StudentRepository.printFilteredStudents(course, filter, null);
            return;
        }

        int numberOfStudents = Integer.parseInt(data[3]);
        StudentRepository.printFilteredStudents(course, filter, numberOfStudents);
    }

    private static void tryPrintOrderedStudents(String input, String[] data) {
        if (data.length != 3 && data.length != 4) {
            displayInvalidCommandMessage(input);
            return;
        }
        String course = data[1];
        String compareType = data[2];
        if (data.length == 3) {
            StudentRepository.printOrderedStudents(course, compareType, null);
            return;
        }

        int numberOfStudents = Integer.parseInt(data[3]);
        StudentRepository.printOrderedStudents(course, compareType, numberOfStudents);
    }

    private static void getHelp() {
        try (BufferedReader bf = new BufferedReader(new FileReader(new File("res\\getHelp.txt")))) {
            String line = "";
            while ((line = bf.readLine()) != null) {
                OutputWriter.writeMessageOnNewLine(line);
            }
            OutputWriter.writeNewLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void tryOpenFile(String input, String[] data) {
        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }
        String fileName = data[1];
        String filePath = SessionData.currentPath + "\\" + fileName;
        File file = new File(filePath);
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException ex) {
            OutputWriter.displayException(ExceptionMessages.FILE_NOT_FOUND);
        }
    }

    private static void tryCreateDirectory(String input, String[] data) {
        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }
        String folderName = data[1];
        IOManager.createDirectoryInCurrentFolder(folderName);
    }

    private static void tryTraverseFolder(String input, String[] data) {
        if (data.length != 1 && data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }
        if (data.length == 1) {
            IOManager.traverseDirectory(0);
        }
        if (data.length == 2) {
            int depth = Integer.parseInt(data[1]);
            IOManager.traverseDirectory(depth);
        }
    }

    private static void tryCompareFiles(String input, String[] data) {
        if (data.length != 3) {
            displayInvalidCommandMessage(input);
            return;
        }
        String firstPath = data[1];
        String secondPath = data[2];
        Tester.compareContent(firstPath, secondPath);
    }

    private static void tryChangeRelativePath(String input, String[] data) {
        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }
        String relativePath = data[1];
        IOManager.ChangeCurrentDirRelativePath(relativePath);
    }

    private static void tryChangeAbsolutePath(String input, String[] data) {
        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }
        String absolutePath = data[1];
        IOManager.changeCurrentDirAbsolute(absolutePath);
    }

    private static void tryReadDatabaseFromFile(String input, String[] data) {
        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }
        String fileName = data[1];
        StudentRepository.initializeData(fileName);
    }

    private static void tryShowWantedCourse(String input, String[] data) {
        if (data.length != 2 && data.length != 3) {
            displayInvalidCommandMessage(input);
            return;
        }
        String courseName = data[1];
        if (data.length == 2) {
            StudentRepository.getStudentsByCourse(courseName);
        }
        if (data.length == 3) {
            String student = data[2];
            StudentRepository.getStudentMarksInCourse(courseName, student);
        }
    }

    private static void displayInvalidCommandMessage(String input) {
        String output = String.format("The command %s is invalid", input);
        OutputWriter.writeMessageOnNewLine(output);
    }
}
