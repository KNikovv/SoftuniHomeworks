package collectionhierarchy;

import collectionhierarchy.models.AddCollection;
import collectionhierarchy.models.AddRemoveCollection;
import collectionhierarchy.models.MyList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static List<Integer> addIndexesFirstList;
    static List<Integer> addIndexesSecondList;
    static List<Integer> addIndexesThirdList;

    static List<String> removedFromSecondList;
    static List<String> removedFromThirdList;

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyList myList = new MyList();

        String[] params = buffReader.readLine().split("\\s+");

        addIndexesFirstList = new ArrayList<>();
        addIndexesSecondList = new ArrayList<>();
        addIndexesThirdList = new ArrayList<>();
        addIndexes(addCollection, addRemoveCollection, myList, params);

        removedFromSecondList = new ArrayList<>();
        removedFromThirdList = new ArrayList<>();
        int removeCount = Integer.valueOf(buffReader.readLine());
        removeElements(addRemoveCollection, myList, removeCount);

        printAll();
    }

    private static void printAll() {
        System.out.println(addIndexesFirstList.stream()
                .map(String::valueOf).collect(Collectors.joining(" ")));
        System.out.println(addIndexesSecondList.stream()
                .map(String::valueOf).collect(Collectors.joining(" ")));
        System.out.println(addIndexesThirdList.stream()
                .map(String::valueOf).collect(Collectors.joining(" ")));

        System.out.println(removedFromSecondList.stream()
                .map(String::valueOf).collect(Collectors.joining(" ")));
        System.out.println(removedFromThirdList.stream()
                .map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static void removeElements(AddRemoveCollection addRemoveCollection, MyList myList, int removeCount) {
        for (int i = 0; i < removeCount; i++) {
            removedFromSecondList.add(addRemoveCollection.remove());
            removedFromThirdList.add(myList.remove());
        }
    }

    private static void addIndexes(AddCollection addCollection, AddRemoveCollection addRemoveCollection, MyList
            myList, String[] params) {
        for (String param : params) {
            addIndexesFirstList.add(addCollection.add(param));
            addIndexesSecondList.add(addRemoveCollection.add(param));
            addIndexesThirdList.add(myList.add(param));
        }
    }
}
