package carTrip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split("\\s+");
        int speed = Integer.parseInt(input[0]);
        double fuel = Double.parseDouble(input[1]);
        double fuelEconomy = Double.parseDouble(input[2]);
        Car car = new Car(speed, fuel, fuelEconomy);

        String line;
        while (!(line = bf.readLine()).equals("END")) {
            input = line.split("\\s+");

            switch (input.length) {
                case 1:
                    String command = input[0];
                    switch (command) {
                        case "Distance":
                            System.out.printf("Total distance: %.1f kilometers\n", car.getTotalTraveledDistance());
                            break;
                        case "Time":
                            System.out.printf("Total time: %d hours and %d minutes\n",car.getHours(),car.getMinutes());
                            break;
                        case "Fuel":
                            System.out.printf("Fuel left: %.1f liters\n", car.getFuel());
                            break;
                    }
                    break;
                case 2:
                    String travellOrRefuel = input[0];
                    double litresOrDistance = Double.parseDouble(input[1]);
                    switch (travellOrRefuel) {
                        case "Travel":
                            car.travel(litresOrDistance);
                            break;
                        case "Refuel":
                            car.refuelCar(litresOrDistance);
                            break;
                    }
                    break;

            }
        }
    }
}

class Car {

    private int speed;
    private double fuel;
    private double fuelEconomy;
    private double totalTraveledDistance;

    Car(int speed, double fuel, double fuelEconomy) {
        this.setSpeed(speed);
        this.setFuel(fuel);
        this.setFuelEconomy(fuelEconomy);
        this.setTotalTraveledDistance(0.0);
    }

    void travel(double distance) {
        double kmPerLitre = this.getSpeed() / this.getFuelEconomy();

        double distanceWithEnoughFuel = (this.getSpeed() / this.getFuelEconomy()) * this.getFuel();
        if (distanceWithEnoughFuel >= distance) {
            this.setTotalTraveledDistance(this.getTotalTraveledDistance() + distance);
            this.setFuel(this.getFuel() - (distance / kmPerLitre));
        } else {
            this.setTotalTraveledDistance(this.getTotalTraveledDistance() + distanceWithEnoughFuel);
            this.setFuel(0.0);
        }
    }
    int getHours(){
        int raw = (int) this.getRawTravelTime();
        int hours = raw / 60;
        return hours;
    }
    int getMinutes(){
        int raw = (int) this.getRawTravelTime();
        int minutes = raw % 60;
        return minutes;
    }
    private double getRawTravelTime() {
        double hoursAndMinutes = (this.getTotalTraveledDistance() / this.getSpeed()) * 60;
        return hoursAndMinutes;
    }

    double getTotalTraveledDistance() {
        return this.totalTraveledDistance;
    }

    private void setTotalTraveledDistance(double traveledDistance) {
        this.totalTraveledDistance = traveledDistance;
    }

    void refuelCar(double extraFuel) {
        this.setFuel(this.getFuel() + extraFuel);
    }

    int getSpeed() {
        return this.speed;
    }

    private void setSpeed(int speed) {
        this.speed = speed;
    }

    double getFuel() {
        return this.fuel;
    }

    private void setFuel(double fuel) {
        this.fuel = fuel;
    }

    double getFuelEconomy() {
        return this.fuelEconomy;
    }

    private void setFuelEconomy(double fuelEconomy) {
        this.fuelEconomy = fuelEconomy;
    }
}
