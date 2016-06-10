
class Student {
    private String firstName;
    private String lastName;
    private String facultyNumber;

    Student(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    Student(String firstName, String lastName, String facultyNumber) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setFacultyNumber(facultyNumber);
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    private void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
