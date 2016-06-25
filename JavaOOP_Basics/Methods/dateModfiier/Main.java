package dateModfiier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String date1 = bf.readLine();
        String date2 = bf.readLine();
        DateModifier dm = new DateModifier();
        long daysBetween = (dm.calculateDifferenceInDays(date1,date2));
        System.out.println(daysBetween);
    }
}

class DateModifier {

    public long calculateDifferenceInDays(String date1,String date2){
        String[] date1split = date1.split("\\s+");
        String[] date2split = date2.split("\\s+");
        Integer y1 = Integer.parseInt(date1split[0]);
        Integer m1 = Integer.parseInt(date1split[1]);
        Integer d1 = Integer.parseInt(date1split[2]);

        Integer y2 = Integer.parseInt(date2split[0]);
        Integer m2 = Integer.parseInt(date2split[1]);
        Integer d2 = Integer.parseInt(date2split[2]);

        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.set(y1,m1,d1);
        calendar2.set(y2,m2,d2);
        Date dt1 = calendar1.getTime();
        Date dt2 = calendar2.getTime();

        long diff = dt2.getTime() - dt1.getTime();
        return Math.abs( diff/( 24 * 60 * 60 * 1000));
    }
}
