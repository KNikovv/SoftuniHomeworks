package fibonacciNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Long start = Long.parseLong(bf.readLine());
        Long end = Long.parseLong(bf.readLine());

        Fibonacci fib = new Fibonacci();
        fib.generateAllFibFrom0toEnd(end);

        List<Long> fibonacciNumbersInRange = fib.getFibonacciNumbersInRange(start, end);

        System.out.println(fibonacciNumbersInRange.stream()
                .map(String::valueOf).collect(Collectors.joining(", ")));
    }
}

class Fibonacci {
    private List<Long> fibonacciNumbers;

    Fibonacci() {
        this.fibonacciNumbers = new ArrayList<>();
    }

    void generateAllFibFrom0toEnd(Long end) {
        Long first = 0L;
        Long second = 1L;
        this.fibonacciNumbers.add(first);
        this.fibonacciNumbers.add(second);
        for (long i = 0; i <= end; i++) {
            Long third = first + second;
            first = second;
            second = third;
            this.fibonacciNumbers.add(third);
        }
    }

    List<Long> getFibonacciNumbersInRange(Long start, Long end) {
        List<Long> fibInRange = new ArrayList<>();
        for (long i = start; i < end; i++) {
            fibInRange.add(this.fibonacciNumbers.get((int)i));
        }
        return fibInRange;
    }
}
