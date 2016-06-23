package google;

public class Pokemon {
    private String pokemonName;
    private String pokemonType;

    public Pokemon(String pokemonName, String pokemonType) {
        this.setPokemonName(pokemonName);
        this.setPokemonType(pokemonType);
    }

    public String getPokemonName() {
        return pokemonName;
    }

    private void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getPokemonType() {
        return pokemonType;
    }

    private void setPokemonType(String pokemonType) {
        this.pokemonType = pokemonType;
    }
    @Override
    public String toString() {
        StringBuilder pokemonBuilder = new StringBuilder();
        pokemonBuilder.append(String.format("%s %s\n",this.getPokemonName(),this.getPokemonType()));
        String pokemonOutput = pokemonBuilder.toString();
        return pokemonOutput;
    }
}
