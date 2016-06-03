import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String keyword = bf.readLine();
        String text = bf.readLine();
        Pattern pat = Pattern.compile("[^.?!]*(?:[.?\\s!])" + keyword + "(?=[\\s.?!])[^.?!]*[.?!]");
        Matcher matcher = pat.matcher(text);

        bf.close();
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }
}