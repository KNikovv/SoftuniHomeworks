package footballTeamGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Team {

    private String teamName;
    private List<Player> players;
    private double rating;

    Team(String... params) {
        this.setTeamName(params);
        this.setPlayers(new ArrayList<>());
        this.setRating(0d);
    }

    public void removePlayer(String playerName) {
        boolean playerExists = false;
        Iterator<Player> iterator = this.players.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getName().equals(playerName)) {
                iterator.remove();
                playerExists = true;
            }
        }
        if (!playerExists) {
            System.out.printf("Player %s is not in %s team.\n", playerName, this.getTeamName());
        }
    }

    public void addPlayer(Player player) {
        if (player.getEndurance() != -1 && player.getSprint() != -1 && player.getShooting() != -1 && player.getPassing()
                != -1 && player.getDribble() != -1) {
            this.players.add(player);
        }
    }

    private String getTeamName() {
        return teamName;
    }

    private void setTeamName(String... params) {
        if (params.length == 1) {
            throw new IllegalArgumentException("A name should not be empty.\n");
        }
        String teamName = params[1];
        if (teamName.isEmpty() || teamName.trim().length() == 0) {
            throw new IllegalArgumentException("A name should not be empty.\n");
        }
        this.teamName = teamName;
    }

    private List<Player> getPlayers() {
        return players;
    }

    private void setPlayers(List<Player> players) {
        this.players = players;
    }

    private double getRating() {
        return rating;
    }

    private void setRating(double rating) {
        this.rating = rating;
    }

    public void calculateRating() {
        double total = 0;
        for (Player player : this.players) {
            total += player.getAvgStats();
        }
        double avg =0;
        if(this.players.size()>0) {
             avg = total / this.players.size();
        }
        this.setRating(avg);
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.getTeamName(), Math.round(this.getRating()));
    }
}
