import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UseYourChainsBuddy {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        bf.close();

        String regex = "<p>(.*?)<\\/p>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        StringBuilder stringBuilder = new StringBuilder();

        while (matcher.find()) {
            stringBuilder.append(matcher.group(1));
        }

        for (int i = 0; i < stringBuilder.length(); i++) {
            if (Character.isLowerCase(stringBuilder.charAt(i))) {
                if (stringBuilder.charAt(i) <= 'm') {
                    stringBuilder.setCharAt(i, (char) (stringBuilder.charAt(i) + 13));
                } else {
                    stringBuilder.setCharAt(i, (char) (stringBuilder.charAt(i) - 13));
                }
            } else {
                if (!Character.isDigit(stringBuilder.charAt(i))) {
                    stringBuilder.setCharAt(i, ' ');
                }
            }
        }
        String output = stringBuilder.toString();
        output = output.replaceAll("\\s+", " ");
        System.out.println(output);
    }
}
