package sample.home;

import sample.models.Adult;
import sample.models.Child;

import java.util.List;

public class HomeCreator {

    public Home createHome(List<String> args, List<Child> children) {
        String command = args.get(0);
        double[] values = args.stream().skip(1).mapToDouble(Double::parseDouble).toArray();
        Home home = null;
        switch (command) {
            case "YoungCoupleWithChildren":
                home = registerYoungCoupleWithKids(values, children);
                break;
            case "YoungCouple":
                home = registerYoungCouple(values);
                break;
            case "OldCouple":
                home = registerOldCouple(values);
                break;
            case "AloneYoung":
                home = registerYoungAlone(values);
                break;
            case "AloneOld":
                home = registerOldAlone(values);
                break;

        }
        home.calculateSalaries();
        home.calculateConsumption();
        return home;
    }

    private YoungCoupleWithChildren registerYoungCoupleWithKids(double[] values, List<Child> children) {
        return new YoungCoupleWithChildren(new Adult(values[0]), new Adult(values[1]), values[2],
                values[3], values[4], children);
    }

    private YoungCouple registerYoungCouple(double[] values) {
        return new YoungCouple(new Adult(values[0]), new Adult(values[1]), values[2],
                values[3], values[4]);
    }

    private OldCouple registerOldCouple(double[] values) {
        return new OldCouple(new Adult(values[0]), new Adult(values[1]), values[2], values[3], values[4]);
    }

    private YoungAlone registerYoungAlone(double[] values) {
        return new YoungAlone(new Adult(values[0]), values[1]);
    }

    private OldAlone registerOldAlone(double[] values) {
        return new OldAlone(new Adult(values[0]));
    }
}
