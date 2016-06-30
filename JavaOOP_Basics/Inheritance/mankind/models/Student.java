package mankind.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student extends Human {

    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.trim().length() < 3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    private void setFacultyNumber(String facultyNumber) {
        Matcher matcher = Pattern.compile("^[a-zA-Z0-9]{5,10}$").matcher(facultyNumber);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Faculty number: %s\n", this.facultyNumber);
    }
}
