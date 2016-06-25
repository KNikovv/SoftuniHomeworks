package printPeople;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Person> personList = new ArrayList<>();
        String line;
        while(!(line = bf.readLine()).equals("END")){
            String [] input = line.split("\\s");
            String name = input[0];
            int age = Integer.valueOf(input[1]);
            String occupation = input[2];
            Person pesho = new Person(name,age,occupation);
            personList.add(pesho);
        }
        personList.stream().sorted(new AgeComparator()).forEach(System.out::println);
    }
}
 class AgeComparator implements Comparator<Person> {

    public int compare(Person p1, Person p2) {
        if(p1.getAge() < p2.getAge()) return -1;
        else if(p1.getAge() > p2.getAge()) return 1;
        else return 0;
    }
}
class Person {
    String name;
    int age;
    String occupation;

     Person(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s - age: %d, occupation: %s",this.name,this.age,this.occupation);
    }
}
