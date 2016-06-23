package google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    public Person(String name) {
        this.setName(name);
        this.setCompany(new Company("","",0));
        this.setCar(new Car("",0));
        this.setPokemons(new ArrayList<>());
        this.setParents(new ArrayList<>());
        this.setChildren(new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    private  void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    private  void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    private  void setCar(Car car) {
        this.car = car;
    }

    public List<Parent> getParents() {
        return parents;
    }

    private  void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    private  void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    private  void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void changeCompany(Company company){
        this.setCompany(company);
    }
    public void changeCar(Car car){
        this.setCar(car);
    }
    public void addPokemon(Pokemon pokemon){
        this.getPokemons().add(pokemon);
    }

    public void addParent(Parent parent){
        this.getParents().add(parent);
    }

    public void addChild(Child child){
        this.getChildren().add(child);
    }
    @Override
    public String toString() {
        StringBuilder personBuilder = new StringBuilder();
        personBuilder.append(this.getName()).append(System.lineSeparator());
        personBuilder.append(this.getCompany().toString());
        personBuilder.append(this.getCar().toString());
        personBuilder.append("Pokemon:\n");
        for(Pokemon pokemon : this.getPokemons()){
            personBuilder.append(pokemon.toString());
        }
        personBuilder.append("Parents:\n");
        for(Parent parent : this.getParents()){
            personBuilder.append(parent.toString());
        }
        personBuilder.append("Children:\n");
        for(Child child : this.getChildren()){
            personBuilder.append(child.toString());
        }

        String personOutput = personBuilder.toString();
        return personOutput;
    }
}
