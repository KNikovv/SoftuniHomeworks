package mankind.models;

public abstract class Human {

    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private void setFirstName(String firstName) {
        char firstLetter = firstName.charAt(0);
        if (Character.isLowerCase(firstLetter)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        if (firstName.trim().length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }


    protected void setLastName(String lastName) {
        char firstLetter = lastName.charAt(0);
        if (Character.isLowerCase(firstLetter)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return  String.format("First Name: %s\nLast Name: %s\n", this.firstName, this.lastName);
    }
}
