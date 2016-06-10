import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.BiPredicate;

public class StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        ArrayList<String> students = new ArrayList<>();

        while (!(line = bf.readLine()).equals("END")) {
            String[] data = line.split("\\s+");
            String firstName = data[0];
            String lastName = data[1];
            String fullName = firstName + " " + lastName;
            students.add(fullName);
        }
        BiPredicate<String,String> predicate = (firstName,secondName)-> {
            return firstName.compareTo(secondName)<0;
        };
        students.stream().filter(a-> {
            String firstName = a.substring(0,a.indexOf(" "));
            String lastName  = a.substring(a.indexOf(" ")+1);
           return predicate.test(firstName,lastName);
        }).forEach(System.out::println);
        bf.close();
    }
}
