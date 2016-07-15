package customlist;

import customlist.interfaces.Sortable;
import customlist.models.CustomListImpl;

public class CommandDispatcher<T extends Comparable> {

    private CustomListImpl<String> customList;
    private Sortable<String> sorter;
    private boolean isEndDispatched;

    public CommandDispatcher(CustomListImpl<String> customList) {
        this.customList = customList;
    }

    public CommandDispatcher(CustomListImpl<String> customList, Sortable<String> sorter) {
        this(customList);
        this.sorter = sorter;
    }

    public boolean isEndDispatched() {
        return isEndDispatched;
    }

    public void dispatch(String... args) {
        String command = args[0];

        switch (command) {
            case "Add":
                this.customList.add(args[1]);
                break;
            case "Remove":
                this.customList.remove(Integer.valueOf(args[1]));
                break;
            case "Contains":
                System.out.println(this.customList.contains(args[1]));
                break;
            case "Swap":
                this.customList.swap(Integer.valueOf(args[1]), Integer.valueOf(args[2]));
                break;
            case "Greater":
                System.out.println(this.customList.countGreaterThan(args[1]));
                break;
            case "Max":
                System.out.println(this.customList.getMax());
                break;
            case "Min":
                System.out.println(this.customList.getMin());
                break;
            case "Print":
                this.customList.print();
                break;
            case "Sort":
                this.sorter.sort();
                break;
            case "END":
                this.isEndDispatched = true;
                break;
        }
    }
}
