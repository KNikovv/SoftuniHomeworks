package pokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    String name;
    int badges;
    ArrayList<Pokemon> pokemonList;

    public Trainer(String name) {
        this.setName(name);
        this.setBadges(0);
        this.pokemonList = new ArrayList<>();
    }

    public ArrayList<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(ArrayList<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }
    public void addBadge(){
        this.setBadges(this.getBadges()+1);
    }
    @Override
    public String toString() {
        return String.format("%s %d %d", this.getName(), this.getBadges(), this.getPokemonList().size());
    }
}
