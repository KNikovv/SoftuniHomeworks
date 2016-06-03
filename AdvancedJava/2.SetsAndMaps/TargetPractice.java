import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TargetPractice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();
        int col = scan.nextInt();
        scan.nextLine();
        String snake = scan.nextLine();
        int impactRow = scan.nextInt();
        int impactCol = scan.nextInt();
        int radius = scan.nextInt();
        ArrayList<ArrayList<Character>> charMatrix = new ArrayList<>(row);
        initialFill(charMatrix, row, col, snake);
        destroyCells(charMatrix,impactRow,impactCol,radius);
        dropChars(charMatrix);
        printMatrix(charMatrix);
    }
    private static void printMatrix(ArrayList<ArrayList<Character>> matrix){
        for(ArrayList<Character> row : matrix){
            for(Character symbol : row){
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
    private static void destroyCells(ArrayList<ArrayList<Character>> matrix, int impactRow , int impactCol,int radius){
        for(int row = 0 ; row <matrix.size();row++){
            for(int col =0 ;col<matrix.get(row).size();col++){
                if(isInDamageArea(row,col,impactRow,impactCol,radius)){
                    matrix.get(row).set(col,' ');
                }
            }
        }
    }
    private static void dropChars(ArrayList<ArrayList<Character>> matrix) {
        for (int row = matrix.size() - 1; row >=0; row--) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                if (matrix.get(row).get(col) != ' ') {
                    int currentRow = row +1;
                    while(currentRow<matrix.size()&&matrix.get(currentRow).get(col)==' '){
                        matrix.get(currentRow).set(col, matrix.get(currentRow-1).get(col));
                        matrix.get(currentRow-1).set(col,' ');
                        currentRow++;
                    }
                }
            }
        }
    }
    private static boolean isInDamageArea(int currentRow, int currentCol, int shotRow, int shotCol, int targetRadius)
    {
        int deltaRow = currentRow - shotRow;
        int deltaCol = currentCol - shotCol;
        return  deltaRow * deltaRow +
                deltaCol * deltaCol
                <= targetRadius * targetRadius;
    }
    private static void initialFill(ArrayList<ArrayList<Character>> matrix, int row, int col, String snake) {
        for (int i = 0; i < row; i++) {
            ArrayList<Character> colList = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                colList.add('0');
            }
            matrix.add(colList);
        }
        StringBuilder snakeBuilder = new StringBuilder(snake);
        int index = 0;
        for (int i = row - 1; i >= 0; i--) {
            if(index%2==0) {
                for (int j = col - 1; j >= 0; j--) {
                    char current;
                    if(snakeBuilder.length()<1){
                        snakeBuilder.append(snake);
                    }
                    current = snakeBuilder.charAt(0);
                    snakeBuilder.deleteCharAt(0);
                    matrix.get(i).set(j, current);
                }
            }else{
                for (int j = 0 ; j < col; j++) {
                    char current ;
                    if(snakeBuilder.length()<1){
                        snakeBuilder.append(snake);
                    }
                    current = snakeBuilder.charAt(0);
                    snakeBuilder.deleteCharAt(0);
                    matrix.get(i).set(j, current);
                }
            }
            index++;
        }
    }
}
