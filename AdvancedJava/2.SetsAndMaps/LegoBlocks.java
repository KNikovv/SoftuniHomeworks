import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegoBlocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<ArrayList<String>> arr1 = new ArrayList<>();
        ArrayList<ArrayList<String>> arr2 = new ArrayList<>();
        addN(n, arr1, sc);
        addN(n, arr2, sc);
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> result = new ArrayList<>();
            for (int j = 0; j < arr1.get(i).size(); j++) {
                result.add(Integer.parseInt(arr1.get(i).get(j)));
            }
            for (int j = arr2.get(i).size()-1; j >= 0; j--) {
                result.add(Integer.parseInt(arr2.get(i).get(j)));
            }

            map.put(i, result);
        }

        boolean isMatch = true;
        ArrayList<Integer> sizes = new ArrayList<>();
        for (Integer row : map.keySet()) {
            sizes.add(map.get(row).size());
        }
        for (int i = 1; i < sizes.size(); i++) {
            int size = sizes.get(i);
            int previoussize = sizes.get(i - 1);
            if (size != previoussize) {
                isMatch = false;
                break;
            }
        }

        if (isMatch) {
            for (Integer row : map.keySet()) {
                System.out.println(map.get(row));
            }
        } else {
            int cells = 0;
            for (Integer row : map.keySet()) {
                cells += map.get(row).size();
            }
            System.out.printf("The total number of cells is: %d", cells);
        }

    }

    public static void addN(int n, ArrayList<ArrayList<String>> list, Scanner s) {
        while (n > 0) {
            String[] arr = s.nextLine().trim().split("\\s+");
            ArrayList<String> c = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                c.add(arr[i]);
            }
            list.add(c);
            n--;
        }
    }
}