package sample;

import sample.home.Home;
import sample.home.HomeCreator;
import sample.models.Child;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        City kermen = new City();
        HomeCreator homecreator = new HomeCreator();

        String line;
        int count = 0;

        while (!(line = buffReader.readLine()).equals("Democracy")) {
            count++;
            if (evnCheck(line, count, kermen)) continue;

            String[] input = line.split(" Child");
            String command = input[0].substring(0, input[0].indexOf("("));
            Pattern pattern = Pattern.compile("[\\d.]+");

            List<String> homeParams = adultsInfo(input[0], command, pattern.matcher(input[0]));
            List<Child> children = childrenInfo(input, pattern);
            Home home = homecreator.createHome(homeParams, children);

            kermen.addHome(home);
            tryToPaySalaries(count, kermen);
        }
        System.out.println(kermen);
    }

    private static List<String> adultsInfo(String input, String command, Matcher matcher) {
        List<String> homeParams = new ArrayList<>();
        homeParams.add(command);
        while (matcher.find()) {
            homeParams.add(matcher.group());
        }
        return homeParams;
    }

    private static List<Child> childrenInfo(String[] input, Pattern pattern) {
        Matcher childMatcher;
        List<Child> children = new ArrayList<>();
        for (int i = 1; i < input.length; i++) {
            childMatcher = pattern.matcher(input[i]);
            childMatcher.find();
            double foodCost = Double.parseDouble(childMatcher.group());
            ArrayList<Double> toysCosts = new ArrayList<>();
            while (childMatcher.find()) {
                double toyCost = Double.parseDouble(childMatcher.group());
                toysCosts.add(toyCost);
            }
            Child child = new Child(foodCost, toysCosts);
            children.add(child);
        }
        return children;
    }

    private static boolean evnCheck(String line, int count, City kermenCity) {
        if (line.equals("EVN")) {
            tryToPaySalaries(count, kermenCity);
            System.out.println("Total consumption: " + kermenCity.getTotalConsumption());
            return true;
        } else if (line.equals("EVN bill")) {
            tryToPaySalaries(count, kermenCity);
            kermenCity.payBills();
            return true;
        }
        return false;
    }

    private static void tryToPaySalaries(int count, City kermenCity) {
        if (count % 3 == 0) {
            kermenCity.receiveSalaries();
        }
    }
}
