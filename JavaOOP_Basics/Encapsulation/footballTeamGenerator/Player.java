package footballTeamGenerator;

public class Player {

    private String name;
    private double endurance;
    private double sprint;
    private double dribble;
    private double passing;
    private double shooting;

    public Player(String name, double endurance, double sprint, double dribble, double passing, double shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("A name should not be empty.\n");
        }
        this.name = name;
    }

    public double getAvgStats() {
        return (this.getEndurance() + this.getDribble() + this.getSprint() + this.getPassing() + this.getShooting())
                / 5d;
    }

    public double getEndurance() {
        return endurance;
    }

    private void setEndurance(double endurance) {
        if (endurance < 0 || endurance >  100) {
            System.out.printf("Endurance should be between 0 and 100.\n");
            this.endurance = -1;
            return;
        }
        this.endurance = endurance;
    }

    public double getSprint() {
        return sprint;
    }

    private void setSprint(double sprint) {
        if (sprint < 0 || sprint > 100) {
            System.out.printf("Sprint should be between 0 and 100.\n");
            this.sprint = -1;
            return;
        }
        this.sprint = sprint;
    }

    public double getDribble() {
        return dribble;
    }

    private void setDribble(double dribble) {
        if (dribble < 0 || dribble >  100) {
            System.out.printf("Dribble should be between 0 and 100.\n");
            this.dribble = -1;
            return;
        }
        this.dribble = dribble;
    }

    public double getPassing() {
        return passing;
    }

    private void setPassing(double passing) {
        if (passing < 0 || passing >  100) {
            System.out.printf("Passing should be between 0 and 100.\n");
            this.passing = -1;
            return;
        }
        this.passing = passing;
    }

    public double getShooting() {
        return shooting;
    }

    private void setShooting(double shooting) {
        if (shooting < 0 || shooting > 100) {
            System.out.printf("Shooting should be between 0 and 100.\n");
            this.shooting = -1;
            return;
        }
        this.shooting = shooting;
    }
}
