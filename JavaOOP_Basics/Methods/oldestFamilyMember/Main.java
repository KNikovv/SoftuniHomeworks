package oldestFamilyMember;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Method getOldestMethod = Family.class.getMethod("getOldestMember");
        Method addMemberMethod = Family.class.getMethod("addFamilyMember",Person.class);
        int people = Integer.parseInt(bf.readLine());
        Family family = new Family();
        for(int i=0;i<people;i++){
            String[] input = bf.readLine().split("\\s");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person(name,age);
            family.addFamilyMember(person);
        }
        Person oldest = family.getOldestMember();
        System.out.println(oldest);
    }
}

 class Family {
    private List<Person> people ;

    public Family() {
        this.people = new ArrayList<>();
    }
    public void addFamilyMember(Person person){
        this.people.add(person);
    }
    public Person getOldestMember(){
        return Collections.max(this.people,new AgeComparator());
    }
     public class AgeComparator implements Comparator<Person> {

         public int compare(Person p1, Person p2) {
             if(p1.getAge() < p2.getAge()) return -1;
             else if(p1.getAge() > p2.getAge()) return 1;
             else return 0;
         }
     }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }

    public int getAge() {
        return age;
    }
}
