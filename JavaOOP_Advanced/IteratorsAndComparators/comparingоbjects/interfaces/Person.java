package comparingоbjects.interfaces;

public interface Person extends Comparable<Person> {

    String getName();

    Integer getAge();

    String getTown();
}
