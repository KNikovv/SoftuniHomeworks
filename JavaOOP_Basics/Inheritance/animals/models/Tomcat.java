package animals.models;

public class Tomcat extends Cat {

    public Tomcat(String name, String age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Give me one million b***h";
    }
}
