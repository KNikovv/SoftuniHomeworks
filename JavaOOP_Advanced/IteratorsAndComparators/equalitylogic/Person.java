package equalitylogic;

public class Person {

    private String name;

    private Integer age;

    public Person(String name, Integer age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj == null || obj.getClass() != this.getClass()) {
            result = false;
        } else {
            Person person = (Person) obj;
            if (person.getName().equals(this.getName()) &&
                    person.getAge().equals(this.getAge())) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 14;
        hash = 7 << hash + this.getName().hashCode();
        hash += 7 << hash + this.getAge().hashCode();
        return hash;
    }

}
