package militaryElite;

import militaryElite.interfaces.*;
import militaryElite.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandDispatcher {

    private MilitaryBase militaryBase;
    private BufferedReader bufferedReader;

    public CommandDispatcher(MilitaryBase militaryBase) {
        this.militaryBase = militaryBase;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void process() throws IOException {

        while (true) {
            String line = this.bufferedReader.readLine();
            if (line.equals("End")) {
                return;
            }
            dispatch(line);
        }
    }

    private void dispatch(String line) {
        String[] args = line.split("\\s+");

        switch (args[0]) {
            case "Private":
                makePrivateSoldier(args);
                break;
            case "LeutenantGeneral":
                makeLeutenant(args);
                break;
            case "Commando":
                makeCommando(args);
                break;
            case "Engineer":
                makeEngineer(args);
                break;
            case "Spy":
                makeSpy(args);
                break;
        }
    }

    private void makeSpy(String[] args) {
        ISpy spy = new Spy(args[1], args[2], args[3], Integer.valueOf(args[4]));
        System.out.print(spy);
    }

    private void makeEngineer(String[] args) {
        try {
            IEngineer engineer = new Engineer(args[1], args[2], args[3], Double.valueOf(args[4]), args[5]);
            for (int i = 6; i < args.length; i += 2) {
                engineer.addRepair(args[i], Integer.valueOf(args[i + 1]));
            }
            System.out.print(engineer);
        } catch (IllegalArgumentException iae) {
            //invalid
        }
    }

    private void makeLeutenant(String[] args) {
        ILeutenantGeneral leutenantGeneral = new LeutenantGeneral(args[1], args[2], args[3], Double
                .valueOf(args[4]));
        for (int i = 5; i < args.length; i++) {
            leutenantGeneral.addPrivates(args[i], this.militaryBase.getAllPrivates());
        }
        System.out.print(leutenantGeneral);
    }

    private void makeCommando(String[] args) {
        try {
            ICommando commando = new Commando(args[1], args[2], args[3], Double.valueOf(args[4]), args[5]);
            for (int i = 6; i < args.length; i += 2) {
                IMission mission = new Mission(args[i], args[i + 1]);
                commando.addMission(mission);
            }
            System.out.print(commando);
        } catch (IllegalArgumentException iae) {
            //invalid
        }
    }

    private void makePrivateSoldier(String[] args) {
        IPrivate soldier = new Private(args[1], args[2], args[3], Double.valueOf(args[4]));
        System.out.print(soldier);
        this.militaryBase.addPrivate(soldier);
    }
}
