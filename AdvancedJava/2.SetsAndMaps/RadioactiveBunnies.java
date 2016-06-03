import java.util.Arrays;
import java.util.Scanner;

public class RadioactiveBunnies {

    private static boolean isDead = false;
    private static boolean hasEscaped = false;
    private static int finishedOnRow = 0;
    private static int finishedOnCol = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        char[][] bunnyLair = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            bunnyLair[row] = scan.nextLine().toCharArray();
        }
        String directions = scan.nextLine();
        for (int index = 0; index < directions.length(); index++) {
            char currentDirection = directions.charAt(index);
            movePlayer(bunnyLair, currentDirection);
            bunnyLair = moveBunnies(bunnyLair);
            if (isDead || hasEscaped) {
                break;
            }
        }
        printLair(bunnyLair);
        String state = isDead ? String.format("dead: %d %d", finishedOnRow, finishedOnCol) :
                String.format("won: %d %d", finishedOnRow, finishedOnCol);
        System.out.println(state);
    }

    private static void printLair(char[][] bunnyLair) {
        for (char[] row : bunnyLair) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static char[][] moveBunnies(char[][] lair) {
        char[][] tempArr = new char[lair.length][lair[0].length];
        for (int row = 0; row < lair.length; row++) {
            for (int col = 0; col < lair[row].length; col++) {
                if (lair[row][col] == 'B') {
                    tempArr[row][col] = 'B';
                    if (row != 0) {
                        if (lair[row - 1][col] == 'P' && !hasEscaped) {
                            isDead = true;
                            finishedOnRow = row - 1;
                            finishedOnCol = col;
                        }
                        tempArr[row - 1][col] = 'B';
                    }
                    if (row != lair.length - 1) {
                        if (lair[row + 1][col] == 'P' && !hasEscaped) {
                            isDead = true;
                            finishedOnRow = row + 1;
                            finishedOnCol = col;
                        }
                        tempArr[row + 1][col] = 'B';
                    }
                    if (col != 0) {
                        if (lair[row][col - 1] == 'P' && !hasEscaped) {
                            isDead = true;
                            finishedOnRow = row;
                            finishedOnCol = col - 1;
                        }
                        tempArr[row][col - 1] = 'B';
                    }
                    if (col != lair[row].length - 1) {
                        if (lair[row][col + 1] == 'P' && !hasEscaped) {
                            isDead = true;
                            finishedOnRow = row;
                            finishedOnCol = col + 1;
                        }
                        tempArr[row][col + 1] = 'B';
                    }
                } else {
                    if (tempArr[row][col] != 'B') {
                        if (lair[row][col] != 'P') {
                            tempArr[row][col] = '.';
                        } else {
                            tempArr[row][col] = 'P';
                        }
                    }
                }
            }
        }
        return tempArr;
    }

    private static void movePlayer(char[][] lair, char direction) {
        boolean changedPos = false;
        for (int row = 0; row < lair.length; row++) {
            for (int col = 0; col < lair[row].length; col++) {
                if (lair[row][col] == 'P') {
                    switch (direction) {
                        case 'U':
                            if (row == 0) {
                                hasEscaped = true;
                            } else {
                                if (lair[row - 1][col] != 'B') {
                                    changedPos = true;
                                    lair[row - 1][col] = 'P';
                                    lair[row][col] = '.';
                                } else {
                                    isDead = true;
                                    finishedOnRow = row - 1;
                                    finishedOnCol = col;
                                }
                            }
                            break;
                        case 'D':
                            if (row == lair.length - 1) {
                                hasEscaped = true;
                            } else {
                                if (lair[row + 1][col] != 'B') {
                                    lair[row + 1][col] = 'P';
                                    lair[row][col] = '.';
                                    changedPos = true;
                                } else {
                                    isDead = true;
                                    finishedOnRow = row + 1;
                                    finishedOnCol = col;
                                }
                            }
                            break;
                        case 'R':
                            if (col == lair[row].length - 1) {
                                hasEscaped = true;
                            } else {
                                if (lair[row][col + 1] != 'B') {
                                    lair[row][col + 1] = 'P';
                                    lair[row][col] = '.';
                                    changedPos = true;
                                } else {
                                    isDead = true;
                                    finishedOnRow = row;
                                    finishedOnCol = col + 1;
                                }
                            }
                            break;
                        case 'L':
                            if (col == 0) {
                                hasEscaped = true;
                            } else {
                                if (lair[row][col - 1] != 'B') {
                                    changedPos = true;
                                    lair[row][col - 1] = 'P';
                                    lair[row][col] = '.';
                                } else {
                                    isDead = true;
                                    finishedOnRow = row;
                                    finishedOnCol = col - 1;
                                }
                            }
                            break;
                    }
                    if (hasEscaped || isDead) {
                        lair[row][col] = '.';
                        if (hasEscaped) {
                            finishedOnRow = row;
                            finishedOnCol = col;
                        }
                        break;
                    }
                }

                if(changedPos){
                    break;
                }
            }
        }
    }
}
