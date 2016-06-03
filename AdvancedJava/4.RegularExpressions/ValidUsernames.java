import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        bf.close();
        Pattern pat = Pattern.compile("(\\w+)");
        Matcher match = pat.matcher(line);
        ArrayList<String> usernameList = new ArrayList<>();
        while (match.find()) {
            if (match.group().length() >= 3 && match.group().length() <= 25) {
                if (!Character.isDigit(match.group().charAt(0))) {
                    usernameList.add(match.group());
                }
            }
        }
        ArrayList<String> resultList = new ArrayList<>();
        int sum = usernameList.get(0).length() + usernameList.get(1).length();
        resultList.add(usernameList.get(0));
        resultList.add(usernameList.get(1));
        for (int i = 1; i < usernameList.size() - 1; i++) {
            String first = usernameList.get(i);
            String second = usernameList.get(i + 1);
            if (first.length() + second.length() > sum) {
                sum = first.length() + second.length();
                resultList.clear();
                resultList.add(first);
                resultList.add(second);
            }
        }
        for (String username : resultList) {
            System.out.println(username);
        }
    }
}