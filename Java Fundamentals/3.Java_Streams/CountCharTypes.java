import java.io.*;

/**
 * Created by kaloy on 3/1/2016.
 */
public class CountCharTypes {
    public static void main(String[] args) {
        File file = new File("resources/words.txt");
        File saveFile = new File("resources/countchars.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            FileWriter fw = new FileWriter(saveFile,true);
            PrintWriter pw = new PrintWriter(fw,true);
            int countVowels = 0;
            int countConsonants = 0;
            int countPunctuation = 0;
            String line = reader.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    if ((line.charAt(i) >= 65 && line.charAt(i) <= 90) || (line.charAt(i) >= 97 && line.charAt(i) <= 122)) {
                        switch (line.charAt(i)) {
                            case 'A':
                            case 'a':
                            case 'E':
                            case 'e':
                            case 'O':
                            case 'o':
                            case 'I':
                            case 'i':
                            case 'U':
                            case 'u':
                                countVowels++;
                                break;
                            default:
                                countConsonants++;
                                break;
                        }

                    } else if (line.charAt(i) == '!' || line.charAt(i) == '?' || line.charAt(i) == '.' || line.charAt(i) == ',') {
                        countPunctuation++;
                    }
                }
                line = reader.readLine();
            }
            pw.printf("Count of vowels: %d", countVowels);
            pw.println();
            pw.printf("Count of consonants: %d", countConsonants);
            pw.println();
            pw.printf("Count of punctuation marks: %d", countPunctuation);
            pw.println();

        } catch (FileNotFoundException ex) {
            System.out.println(0);
        } catch (IOException ex) {
            System.out.println(0);
        }


    }
}
