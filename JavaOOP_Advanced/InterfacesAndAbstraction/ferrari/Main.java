package ferrari;

import ferrari.interfaces.Car;
import ferrari.models.Ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;

public class Main {

    public static void main(String[] args) throws IllegalClassFormatException, IOException {

        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        String driverName = buffReader.readLine();

        Car car = new Ferrari(driverName);
        System.out.println(car);


        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Car.class.getSimpleName();
        boolean isCreated = Car.class.isInterface();
        if (!isCreated) {
            throw new IllegalClassFormatException("No interface created!");
        }

    }
}
