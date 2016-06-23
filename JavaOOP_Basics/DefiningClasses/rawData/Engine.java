package rawData;

public class Engine {
    private int speed;
    private int power;

    public int getPower() {
        return power;
    }

    private void setPower(int power) {
        this.power = power;
    }

    public Engine(int speed, int power) {
        this.speed = speed;
        this.power = power;

    }
}
