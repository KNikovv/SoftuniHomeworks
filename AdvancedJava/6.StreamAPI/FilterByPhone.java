import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.function.Predicate;

public class FilterByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        LinkedHashMap<String,String> phoneBook = new LinkedHashMap<>();
        while(!(line=bf.readLine()).equals("END")){
            String [] data = line.split("\\s+");
            String fullname = data[0] + " " + data[1];
            String phoneNumber = data[2];
            phoneBook.put(phoneNumber,fullname);

        }
        Predicate<String> phoneFilter = (p) -> p.startsWith("02")||p.startsWith("+3592");
        phoneBook.entrySet().stream()
                .filter(p->phoneFilter.test(p.getKey()))
                .forEach(s-> System.out.println(s.getValue()));
    }
}
