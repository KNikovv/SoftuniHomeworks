import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReplaceAllAtags {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = bf.readLine();
        while(!line.equals("end")){
            String openTag = "[URL";
            String closeTag = "[/URL]";
            line =line.replaceAll("<a",openTag);
            line =line.replaceAll("</a>",closeTag);
            sb.append(line);
            line =bf.readLine();
        }
        System.out.println(sb);
        bf.close();
    }
}
