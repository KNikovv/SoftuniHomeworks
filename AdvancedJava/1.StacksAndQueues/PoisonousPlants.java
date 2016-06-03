import java.util.*;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] plants = new int[n];
        for (int i = 0; i < n; i++) {
            plants[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int[] daySpan = new int[n];
        int min = plants[0];
        int max = 1;

        for (int i = 1; i < n ; i++) {
            int currentPlant = plants[i];
            if (currentPlant <= min) {
                min = currentPlant;
                stack.clear();
                continue;
            }

            if (stack.empty()) {
                stack.push(i);
                daySpan[i] = 1;
                continue;
            }

            int currentSpan = 1;
            int poppedIndex = stack.pop();

            while (currentPlant <= plants[poppedIndex]) {
                currentSpan = daySpan[poppedIndex] + 1;

                if (!stack.empty()) {
                    poppedIndex = stack.pop();
                } else {
                    break;
                }
            }

            daySpan[i] = currentSpan;
            if (currentSpan < daySpan[poppedIndex]) {
                stack.push(poppedIndex);
            }
            stack.push(i);

            if (currentSpan > max) {
                max = currentSpan;
            }
        }

        System.out.println(max);
    }
}