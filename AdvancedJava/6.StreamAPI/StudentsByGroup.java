import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        while (!(line = bf.readLine()).equals("END")) {
            String[] data = line.split("\\s+");
            int group = Integer.parseInt(data[2]);
            String firstName = data[0];
            String lastName = data[1];
            String fullName = firstName + " " + lastName;
            if (!map.containsKey(group)) {
                map.put(group, new ArrayList<>());
            }
            map.get(group).add(fullName);
        }
        map.entrySet().stream()
                .filter(group -> group.getKey() == 2)
                .forEach(e -> {
                    e.getValue().stream()
                            .sorted((student1, student2) -> {
                                String firstStudentFirstName = student1.substring(0, student1.indexOf(" "));
                                String secondStudentFirstName = student2.substring(0, student2.indexOf(" "));
                                return firstStudentFirstName.compareTo(secondStudentFirstName);
                            }).forEach(System.out::println);
                });
        bf.close();
    }
}
