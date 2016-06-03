import java.util.Arrays;
import java.util.Scanner;

public class RubikMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] rowcols = scan.nextLine().split(" ");
        int lines = Integer.parseInt(scan.nextLine());
        int rows = Integer.parseInt(rowcols[0]);
        int cols = Integer.parseInt(rowcols[1]);
        int[][] matrix = new int[rows][cols];
        int n = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = n++;
            }
        }
        int[][] matrix2 = copy(matrix);
        while (lines > 0) {
            String[] line = scan.nextLine().split(" ");
            int colorRow = Integer.parseInt(line[0]);
            String direction = line[1];
            int moves = Integer.parseInt(line[2]);

            matrix2 = rotateMatrix(direction, matrix2, moves, cols, rows, colorRow);
            lines--;

        }
        System.out.println(rearrangeMatrix(matrix, matrix2));
    }

    private static String rearrangeMatrix(int[][] matrix, int[][] matrix2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int element = matrix[i][j];
                int secondMatrixElement = matrix2[i][j];
                if (element == secondMatrixElement) {
                    sb.append("No swap required\n");
                } else {
                    for (int p = 0; p < matrix2.length; p++) {
                        for (int k = 0; k < matrix2[0].length; k++) {
                            if (matrix2[p][k] == element) {
                                matrix2[i][j] = matrix2[p][k];
                                matrix2[p][k] = secondMatrixElement;
                                sb.append(String.format("Swap (%d, %d) with (%d, %d)\n", i, j, p, k));
                                break;
                            }
                        }
                    }
                }
            }

        }
        String output = sb.toString();
        return output;
    }

    public static int[][] rotateMatrix(String direction, int[][] matrix2, int moves, int cols, int rows,
                                       int rowOrColumn) {
        int row = rowOrColumn;
        int col = rowOrColumn;
        switch (direction) {
            case "left":
                for (int i = 0; i < moves % cols; i++) {
                    int temp = matrix2[row][0];
                    for (int j = 1; j < cols; j++) {
                        matrix2[row][j - 1] = matrix2[row][j];
                    }

                    matrix2[row][cols - 1] = temp;
                }
                break;
            case "right":
                for (int i = 0; i < moves % cols; i++) {
                    int temp = matrix2[row][cols - 1];
                    for (int j = cols - 1; j >= 1; j--) {
                        matrix2[row][j] = matrix2[row][j - 1];
                    }

                    matrix2[row][0] = temp;
                }
                break;
            case "up":
                for (int i = 0; i < moves % rows; i++) {
                    int temp = matrix2[0][col];
                    for (int j = 1; j < rows; j++) {
                        matrix2[j - 1][col] = matrix2[j][col];
                    }
                    matrix2[rows - 1][col] = temp;
                }
                break;
            case "down":
                for (int i = 0; i < moves % rows; i++) {
                    int temp = matrix2[rows - 1][col];
                    for (int j = rows - 1; j >= 1; j--) {
                        matrix2[j][col] = matrix2[j - 1][col];
                    }
                    matrix2[0][col] = temp;
                }
                break;
        }
        return matrix2;
    }

    public static int[][] copy(int[][] src) {
        int[][] dst = new int[src.length][];
        for (int i = 0; i < src.length; i++) {
            dst[i] = Arrays.copyOf(src[i], src[i].length);
        }
        return dst;
    }
}