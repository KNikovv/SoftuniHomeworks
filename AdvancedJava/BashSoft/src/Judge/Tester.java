package Judge;

import IO.OutputWriter;
import StaticData.ExceptionMessages;

import java.io.*;
import java.util.ArrayList;

public class Tester {
    public static void compareContent(String actualOutput, String expectedOutput) {
        try {
            OutputWriter.writeMessageOnNewLine("Reading files...");

            String mismatchPath = getMismatchPath(expectedOutput);

            ArrayList<String> actualOutputString = readTextFile(actualOutput);
            ArrayList<String> expectedOutputString = readTextFile(expectedOutput);

            boolean mismatch = compareStrings(actualOutputString, expectedOutputString, mismatchPath);

            if (mismatch) {
                ArrayList<String> mismatchString = readTextFile(mismatchPath);
                mismatchString.forEach(OutputWriter::writeMessageOnNewLine);
            } else {
                OutputWriter.writeMessageOnNewLine("Files are identical.There are no mismatches");
            }
        } catch (IOException ex) {
            OutputWriter.displayException(ExceptionMessages.INVALID_PATH);
        }
    }

    private static String getMismatchPath(String expectedOutput) {
        int index = expectedOutput.lastIndexOf('\\');
        String directoryPath = expectedOutput.substring(0, index);
        return directoryPath + "\\mismatch.txt";
    }

    private static ArrayList<String> readTextFile(String filePath) throws IOException {
        ArrayList<String> textFile = new ArrayList<>();

        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            textFile.add(line);
        }
        bufferedReader.close();
        return textFile;
    }

    private static boolean compareStrings(ArrayList<String> actualOutput,
                                          ArrayList<String> expectedOutput,
                                          String mismatchPath) {
        OutputWriter.writeMessageOnNewLine("Comparing files...");
        String output = "";
        boolean isMismatch = false;
        int maxLength = Math.max(actualOutput.size(),expectedOutput.size());
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(mismatchPath))) {
            for (int i = 0; i < maxLength; i++) {
                String actualLine = actualOutput.get(i);
                String expectedLine = expectedOutput.get(i);

                if (!actualLine.equals(expectedLine)) {
                    output = String.format("mismatch -> expected{%s}, actual{%s}", expectedLine, actualLine);
                    isMismatch = true;
                } else {
                    output = String.format("line match -> %s", actualLine);
                }

                bufferedWriter.write(output);
                bufferedWriter.newLine();
            }
        } catch (IOException ex) {
            isMismatch = true;
            OutputWriter.displayException(ExceptionMessages.CANNOT_ACCESS_FILE);
            OutputWriter.writeNewLine();
        } catch(IndexOutOfBoundsException ex){
            isMismatch = true;
            OutputWriter.displayException(ExceptionMessages.INVALID_OUTPUT_LENGTH);
            OutputWriter.writeNewLine();
        }
        return isMismatch;
    }
}
