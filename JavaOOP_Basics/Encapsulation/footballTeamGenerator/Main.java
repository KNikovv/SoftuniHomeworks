package footballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        HashMap<String, Team> teamMap = new HashMap<>();
        while (!(line = bf.readLine()).equals("END")) {
            String[] params = line.split(";");
            switch (params[0]) {
                case "Team":
                    try {
                        Team team = new Team(params);
                        teamMap.put(params[1], team);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Add": {
                    String teamName = params[1];
                    String playerName = params[2];
                    double endurance = Double.valueOf(params[3]);
                    double sprint = Double.valueOf(params[4]);
                    double dribble = Double.valueOf(params[5]);
                    double passing = Double.valueOf(params[6]);
                    double shooting = Double.valueOf(params[7]);

                    try {
                        if (!teamMap.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.\n", teamName);

                            continue;
                        }
                        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        teamMap.get(teamName).addPlayer(player);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case "Remove": {
                    String teamName = params[1];
                    String playerName = params[2];
                    if (!teamMap.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.\n", teamName);
                        continue;
                    }
                    teamMap.get(teamName).removePlayer(playerName);
                    break;
                }
                case "Rating":
                    String teamName = params[1];
                    if (!teamMap.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.\n", teamName);
                        continue;
                    }
                    teamMap.get(teamName).calculateRating();
                    System.out.println(teamMap.get(teamName));
                    break;
            }
        }
    }

}
