package catLady;

public abstract class Cat  {
    String name;
    String breed;
    String catSpecific;


    public Cat(String name, String catSpecific) {
            this.setName(name);
            this.setCatSpecific(catSpecific);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCatSpecific() {
        return catSpecific;
    }

    public void setCatSpecific(String catSpecific) {
        this.catSpecific = catSpecific;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s",this.getClass().getSimpleName(),this.getName(),this.getCatSpecific());
    }
}
