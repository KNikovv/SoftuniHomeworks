package google;

public class Car {
    private String carModel;
    private int carSpeed;

    public Car(String carModel, int carSpeed) {
        this.setCarModel(carModel);
        this.setCarSpeed(carSpeed);
    }

    public String getCarModel() {
        return carModel;
    }

    private void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarSpeed() {
        return carSpeed;
    }

    private void setCarSpeed(int carSpeed) {
        this.carSpeed = carSpeed;
    }
    @Override
    public String toString() {
        StringBuilder carBuilder = new StringBuilder();
        carBuilder.append("Car:\n");
        if(this.getCarModel()!=""){
            carBuilder.append(String.format("%s %d\n",this.getCarModel(),this.getCarSpeed()));
        }
        String carOutput = carBuilder.toString();
        return carOutput;
    }
}
