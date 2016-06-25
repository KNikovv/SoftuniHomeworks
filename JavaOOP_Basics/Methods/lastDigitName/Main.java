package lastDigitName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int numberValue = Integer.parseInt(bf.readLine());
        Number number = new Number(numberValue);
        System.out.println(number.returnDigitName(number.getValue()));
    }
}
class Number{
    private int value;
    private static final String[] DIGITS_AS_WORDS = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
    Number(int value) {
        this.value = value;
    }
    int getValue() {
        return value;
    }

    String returnDigitName(int value){
        return DIGITS_AS_WORDS[value%10];
    }
}