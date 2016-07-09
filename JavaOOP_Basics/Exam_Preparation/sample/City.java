package sample;

import sample.home.Home;

import java.util.ArrayList;
import java.util.Iterator;

public class City {

    private ArrayList<Home> homes;

    public City() {
        this.homes = new ArrayList<>();
    }

    public int getPeopleCount() {
        int count = this.homes.stream().mapToInt(Home::getPopulationCount).sum();
        return count;
    }

    public void payBills() {
        Iterator<Home> iterator = homes.iterator();

        while (iterator.hasNext()) {
            if (!iterator.next().payConsumption()) {
                iterator.remove();
            }
        }
    }

    public void addHome(Home home) {
        this.homes.add(home);
    }

    public double getTotalConsumption() {
        double consumption;
        consumption = this.homes.stream().mapToDouble(Home::getConsumption).sum();
        return consumption;
    }

    public void receiveSalaries() {
        this.homes.stream().forEach(Home::paySalaries);
    }

    @Override
    public String toString() {
        return String.format("Total population: %d", this.getPeopleCount());
    }
}
