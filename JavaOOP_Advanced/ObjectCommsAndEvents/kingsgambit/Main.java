package kingsgambit;

import kingsgambit.interfaces.CommandDispatcher;
import kingsgambit.interfaces.king.King;
import kingsgambit.interfaces.unit.Unit;
import kingsgambit.models.Footman;
import kingsgambit.models.KingImpl;
import kingsgambit.models.RoyalGuard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        String kingName = buffReader.readLine();
        King king = new KingImpl(kingName);
        List<Unit> units = new LinkedList<>();

        String[] royalGuardsNames = buffReader.readLine().split("\\s+");
        addGuards(king,royalGuardsNames, units);

        String[] footmenNames = buffReader.readLine().split("\\s+");
        addFootmen(king,footmenNames, units);

        king.addUnits(units);

        CommandDispatcher commandDispatcher = new CommandDispatcherImpl(king);

        while (true) {
            String[] params = buffReader.readLine().split("\\s+");
            if (params[0].toLowerCase().equals("end")) {
                break;
            }

            commandDispatcher.execute(params);
        }
    }

    private static void addGuards(King king ,String[] royalGuardsNames, List<Unit> units) {
        for (String name : royalGuardsNames) {
            Unit unit = new RoyalGuard(name, king);
            units.add(unit);
        }
    }

    private static void addFootmen(King king ,String[] footmenNames, List<Unit> units) {
        for (String name : footmenNames) {
            Unit unit = new Footman(name,king);
            units.add(unit);
        }
    }
}
