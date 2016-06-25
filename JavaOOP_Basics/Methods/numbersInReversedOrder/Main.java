package numbersInReversedOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder value = new StringBuilder(bf.readLine());
        DecimalNumber number = new DecimalNumber(value);
        number.reverse();
        System.out.println(number);
    }
}

class DecimalNumber {
    private StringBuilder value;

     DecimalNumber(StringBuilder value) {
        this.value = value;
    }

     void reverse() {
        this.value = value.reverse();
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
