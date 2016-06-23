package pokemonTrainer;

public class Pokemon {
    String name;
    String element;
    int health;

    public Pokemon(String name,int health,  String element) {
        this.setName(name);
        this.setHealth(health);
        this.setElement(element);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public void removeHealth(){
        this.setHealth(this.getHealth()-10);
    }
}
