import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Person> personList = new ArrayList<>();
        String line;
        while(!(line = bf.readLine()).equals("END")){
            String [] data = line.split("\\s+");
            String fullName = data[0] + " " + data[1];
            int group = Integer.parseInt(data[2]);
            Person tempPerson = new Person(fullName,group);
            personList.add(tempPerson);
        }
        personList.stream().collect(Collectors.groupingBy(Person::getGroup)).forEach((group, person) -> {
            System.out.printf("%d - ",group);
            StringBuilder stringBuilder = new StringBuilder();
            for(Person current : person){
                stringBuilder.append(String.format("%s, ",current.getName()));
            }
            stringBuilder.setLength(stringBuilder.length()-2);
            System.out.println(stringBuilder);
        });
    }
}
class Person{
    private String name;
    private  int group;

    public Person(String name, int group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }


}