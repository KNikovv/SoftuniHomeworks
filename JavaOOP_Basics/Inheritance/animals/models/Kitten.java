package animals.models;

public class Kitten extends Cat {

    public Kitten(String name, String age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Miau";
    }
}
