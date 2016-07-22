package trafficlight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        String[] initialState = buffReader.readLine().toUpperCase().split("\\s+");

        Signal[] signals = readLights(initialState);

        int lines = Integer.valueOf(buffReader.readLine());

        changeLights(signals, lines);

    }

    private static void changeLights(Signal[] signals, int n) {
        for (int i = 0; i < n; i++) {
            for (int index = 0; index < signals.length; index++) {
                int next = (signals[index].ordinal() + 1) % 3;
                signals[index] = Signal.values()[next];
            }
            System.out.println(String.join(" ", Arrays.toString(signals)).replaceAll("[,\\[\\]]", ""));
        }
    }

    private static Signal[] readLights(String... params) {
        Signal[] temp = new Signal[params.length];
        for (int i = 0; i < params.length; i++) {
            temp[i] = Enum.valueOf(Signal.class, params[i]);
        }
        return temp;
    }

}

enum Signal {
    RED,
    GREEN,
    YELLOW
}