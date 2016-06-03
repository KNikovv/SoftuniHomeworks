import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Pattern pat = Pattern.compile("[+]359\\s2\\s[0-9]{3}\\s[0-9]{4}|[+]359-2-[0-9]{3}-[0-9]{4}\\b");

        String line = bf.readLine();
        while (!line.equals("end")){
            Matcher matcher = pat.matcher(line);
            if(matcher.find()){
                System.out.println(matcher.group());
            }
            line = bf.readLine();
        }
        bf.close();
    }
}


