import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticalHTML {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Pattern openPattern = Pattern.compile("(\\s*)?<div\\s*(.+)?(?:\\s*id\\s*=\\s*\"|\\s*class\\s*=\\s*\")\\s*([^\"]+\\s*)\"\\s*(.+)?>");
        Pattern closePattern = Pattern.compile("(\\s*)?(?:<\\s*\\/div\\s*>)\\s*<(?:[!-]+)\\s*(\\w+)\\s*(?:[-]+)>");
        String line = "";
        StringBuilder stringBuilder = new StringBuilder(line);
        while (!(line = bf.readLine()).equals("END")) {
            Matcher openMatcher = openPattern.matcher(line);
            Matcher closeMatcher = closePattern.matcher(line);
            //open tags
            if (openMatcher.find()) {
                if (openMatcher.group(1) != null) {
                    stringBuilder.append(openMatcher.group(1));
                }
                stringBuilder.append("<").append(openMatcher.group(3).trim());
                if (openMatcher.group(2) != null) {
                    String content = openMatcher.group(2).replaceAll("\\s+"," ").trim();
                    stringBuilder.append(" ").append(content);
                }
                if (openMatcher.group(4) != null) {
                    String content = openMatcher.group(4).replaceAll("\\s+"," ").trim();
                    stringBuilder.append(" ").append(content);
                }
                stringBuilder.append(">");
            }
            //close tags
            else if (closeMatcher.find()) {
                String frontPart = "";
                if (closeMatcher.group(1) != null) {
                    frontPart = closeMatcher.group(1);
                }

                stringBuilder.append(frontPart);
                stringBuilder.append("</").append(closeMatcher.group(2)).append(">");
            } else {
                stringBuilder.append(line);
            }

            stringBuilder.append(System.getProperty("line.separator"));
        }

        System.out.println(stringBuilder);
    }
}

