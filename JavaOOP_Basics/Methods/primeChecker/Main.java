package primeChecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(bf.readLine());

        PrimeChecker primeChecker = new PrimeChecker();
        boolean isPrime = primeChecker.checkIsItPrime(number);
        Number firstNumber = new Number(number, isPrime);

        PrimeFinder primeFinder = new PrimeFinder();
        Number resultNumber = primeFinder.findNextPrime(number);
        System.out.println(resultNumber);
    }

}

class PrimeChecker {

    PrimeChecker() {

    }

    boolean checkIsItPrime(int number) {
        double divider = Math.sqrt(number);
        for (int div = 2; div <= divider; div++) {
            if (number % div == 0) {
                return false;
            }
        }
        return true;
    }
}

class PrimeFinder {

    private PrimeChecker primeChecker;
    private boolean prime;

    PrimeFinder() {
        this.primeChecker = new PrimeChecker();
    }

    Number findNextPrime(int number) {
        prime = primeChecker.checkIsItPrime(number);
        int tempNumber = number;
        boolean isNextPrime = false;
        while (!isNextPrime) {
            tempNumber++;
            isNextPrime = this.primeChecker.checkIsItPrime(tempNumber);
        }
        return new Number(tempNumber, this.prime);
    }
}

class Number {

    private boolean prime;
    private int number;

    Number(int number, boolean prime) {
        this.number = number;
        this.prime = prime;
    }

    @Override
    public String toString() {
        return this.number + ", " + this.prime;
    }
}
