package pokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        LinkedHashMap<String, Trainer> trainerMap = new LinkedHashMap<>();
        while (!(line = bf.readLine()).equals("Tournament")) {
            String[] input = line.split("\\s+");
            String trainerName = input[0];
            String pokemonName = input[1];
            String element = input[2];
            int pokemonHealth = Integer.parseInt(input[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonHealth, element);
            if (!trainerMap.containsKey(trainerName)) {
                Trainer trainer = new Trainer(trainerName);
                trainerMap.put(trainerName, trainer);
            }
            trainerMap.get(trainerName).getPokemonList().add(pokemon);
        }

        while (!(line = bf.readLine()).equals("End")) {

            String currentElement = line;

            for (Map.Entry<String, Trainer> trainerEntry : trainerMap.entrySet()) {

                Trainer currentTrainer = trainerEntry.getValue();
                ArrayList<Pokemon> pokemons = trainerEntry.getValue().getPokemonList();
                boolean containsElement = false;
                for (Pokemon pokemon : pokemons) {
                    if (pokemon.getElement().equals(currentElement)) {
                        currentTrainer.addBadge();
                        containsElement = true;
                        break;
                    }
                }
                if (!containsElement) {
                    for (Pokemon pokemon : pokemons) {
                        pokemon.removeHealth();
                    }
                }
                currentTrainer.getPokemonList().removeIf(pokemon -> pokemon.getHealth()<=0);
            }
        }
        trainerMap.values().stream()
                .sorted((t1, t2) -> Integer.compare(t2.getBadges(), t1.getBadges()))
                .forEach(System.out::println);
    }
}
