package equalitylogic;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int byName = o1.getName().compareTo(o2.getName());
        int byAge = o1.getAge().compareTo(o2.getAge());


        if (byName != 0) {
            return byName;
        }
        if (byAge != 0) {
            return byAge;
        }

        return 0;
    }
}
