import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Pattern pat = Pattern.compile("\\b[A-Z][a-z]+\\s[A-Z][a-z]+\\b");
        String line = bf.readLine();
        while(!line.equals("end")){
            Matcher matcher = pat.matcher(line);
            while(matcher.find()){
                System.out.println(matcher.group());
            }
            line = bf.readLine();
        }
        bf.close();
    }
}
