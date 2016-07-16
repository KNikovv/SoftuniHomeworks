package borderControl;

import borderControl.interfaces.Birthdateable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        Factory unitFactory = new Factory();
        List<Birthdateable> birthdateables = new ArrayList<>();

        String line = buffReader.readLine();
        while (true) {
            String[] params = line.split("\\s+");

            if (params[0].equals("End")) {
                break;
            }

            Birthdateable unit = unitFactory.createUnit(params);
            if(unit!= null) {
                birthdateables.add(unit);
            }
            line = buffReader.readLine();
        }
        String birthdateYear = buffReader.readLine();

        birthdateables.stream()
                .filter(unit -> unit.getBirthdate().endsWith(birthdateYear))
                .forEach(unit -> System.out.println(unit.getBirthdate()));
    }
}
