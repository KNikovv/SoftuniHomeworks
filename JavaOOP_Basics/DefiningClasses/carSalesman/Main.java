package carSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Car> carList = new ArrayList<>();
    static List<Engine> engineList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int engineCount = Integer.parseInt(bf.readLine());
        for(int i = 0;i <engineCount ;i++){
            String [] engineInput = bf.readLine().split("\\s+");
            addEngine(engineInput);
        }
        int carCount = Integer.parseInt(bf.readLine());
        for(int i = 0; i< carCount;i++){
            String [] carInput = bf.readLine().split("\\s+");
            addCar(carInput);
        }
        carList.stream().forEach(System.out::println);
    }

    private static void addCar(String[] carInput) {

        String carModel = carInput[0];
        String engineModel = carInput[1];
        String carWeight = null;
        String  carColor = null;

        if(carInput.length>2){
            carWeight = tryParse(carInput[2]);
            carColor = carInput.length>3 ? carInput[3] : carWeight==null ? carInput[2] : null;
        }
        for(Engine engine : engineList){
            if(engine.getEngineModel().equals(engineModel)){
                Car currentCar = new Car(carModel,engine,carWeight,carColor);
                carList.add(currentCar);
                break;
            }
        }
    }

    public static void addEngine(String[] engineInput){
        String engineModel = engineInput[0];
        Integer enginePower = Integer.parseInt(engineInput[1]);
        String engineDisplacement = null;
        String engineEfficiency = null;
        if(engineInput.length>2){
            engineDisplacement = tryParse(engineInput[2]);
            engineEfficiency = engineInput.length>3 ? engineInput[3] : engineDisplacement==null ? engineInput[2] : null;
        }
        Engine currentEngine = new Engine(engineModel,enginePower,engineDisplacement,engineEfficiency);
        engineList.add(currentEngine);
    }
    public static String tryParse(Object obj) {
        String retVal;
        Integer tryNum;
        try {
            tryNum = Integer.parseInt((String) obj);
            retVal = tryNum.toString();
        } catch (NumberFormatException nfe) {
            retVal = null; // or null if that is your preference
        }
        return retVal;
    }
}
