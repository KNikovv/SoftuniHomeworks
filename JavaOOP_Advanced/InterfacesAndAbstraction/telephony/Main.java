package telephony;

import telephony.models.Smartphone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = buffReader.readLine().split("\\s+");
        String[] sites = buffReader.readLine().split("\\s+");
        
        Smartphone smartphone = new Smartphone();
        
        callNumbers(numbers, smartphone);
        
        browseWeb(sites, smartphone);
        
    }

    private static void callNumbers(String[] numbers, Smartphone smartphone) {
        for(String number : numbers){
            try{
                smartphone.callNumber(number);
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }
    }

    private static void browseWeb(String[] sites, Smartphone smartphone) {
        for(String site : sites){
            try{
                smartphone.browseSite(site);
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }
    }
}
