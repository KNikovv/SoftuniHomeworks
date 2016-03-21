import javax.xml.stream.StreamFilter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortIntArray {

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int [] intArray = new int[n];
            for(int i=0;i<n;i++){
                intArray[i] = sc.nextInt();
            }
        Arrays.sort(intArray);
        for (int num : intArray) {
            System.out.print(num + " ");
        }

    }
}
