import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] matrixdimensions = sc.nextLine().split(" ");
        int rows = Integer.parseInt(matrixdimensions[0]);
        int cols = Integer.parseInt(matrixdimensions[1]);
        int n = 1;
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> colsList = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                colsList.add(n++);
            }
            matrix.add(colsList);
        }
        String input = sc.nextLine();
        ArrayList<ArrayList<Integer>> r = new ArrayList<>();
        while (!input.equals("Nuke it from orbit")) {
            String[] data = input.split(" ");
            int row = Integer.parseInt(data[0]);
            int col = Integer.parseInt(data[1]);
            int radius = Integer.parseInt(data[2]);
            deleteNums(row, col, radius, matrix);
            for (int i = matrix.size() - 1; i >= 0; i--) {
                for (int j = matrix.get(i).size() -1; j >= 0 ; j--) {
                    if (matrix.get(i).get(j) == 0) {
                        matrix.get(i).remove(j);
                    }
                    if (matrix.get(i).size() == 0) {
                        matrix.remove(i);
                    }
                }
            }
            input = sc.nextLine();
        }
        for (ArrayList<Integer> arrayList : matrix) {
            for(Integer num : arrayList){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static void deleteNums(int row, int col, int radius, ArrayList<ArrayList<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (i == row) {
                    if (j >= col - radius && j <= radius + col) {
                        matrix.get(i).set(j, 0);
                    }
                }
                if (j == col) {
                    if (i >= row - radius && i <= radius + row) {
                        matrix.get(i).set(j, 0);
                    }
                }
            }
        }
    }
}