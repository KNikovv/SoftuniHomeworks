import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.function.Predicate;

public class FilterByEmail {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        LinkedHashMap<String,String> emailData = new LinkedHashMap<>();
        while(!(line=bf.readLine()).equals("END")){
            String [] inputData = line.split("\\s+");
            String fullName = inputData[0] + " " + inputData[1];
            String email = inputData[2];
            emailData.put(email,fullName);
        }
        Predicate<String> emailPredicate = (email) -> email.contains("@gmail.com");
        emailData.entrySet().stream()
                .filter(emailInfo->{
            return emailPredicate.test(emailInfo.getKey());
        })
                .forEach(e1-> System.out.println(e1.getValue()));
        emailData.forEach((e,e1)-> System.out.println(e.charAt(0)));
    }
}
