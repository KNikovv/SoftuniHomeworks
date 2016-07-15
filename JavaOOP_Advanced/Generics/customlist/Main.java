package customlist;

import customlist.interfaces.Sortable;
import customlist.models.CustomListImpl;
import customlist.models.Sorter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        CustomListImpl<String> customStringList = new CustomListImpl<>();
        Sortable<String> customSorter = new Sorter<>(customStringList);
        CommandDispatcher commandDispatcher = new CommandDispatcher(customStringList,customSorter);

        while (!commandDispatcher.isEndDispatched()) {
            String[] params = buffReader.readLine().split("\\s+");
            commandDispatcher.dispatch(params);
        }
    
    }
}
