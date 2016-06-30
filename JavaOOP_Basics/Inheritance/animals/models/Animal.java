package animals.models;

import animals.interfaces.SoundProducable;

public class Animal implements SoundProducable {

    private String name;
    private String age;
    private String gender;

    public Animal(String name, String age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private String getAge() {
        return age;
    }

    private void setAge(String age) {
        int intValue = Integer.valueOf(age);
        if (age.isEmpty() || age.trim().length() == 0 || intValue < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    private String getGender() {
        return gender;
    }

    private void setGender(String gender) {
        if (gender.isEmpty() || gender.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        if (!gender.toLowerCase().equals("male") && !gender.toLowerCase().equals("female")) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    @Override
    public String produceSound() {
        return "Not implemented!";
    }

    @Override
    public String toString() {
        return String.format("%s\n%s %s %s\n%s",
                this.getClass().getSimpleName(),
                this.getName(),
                this.getAge(),
                this.getGender(),
                this.produceSound());
    }
}
