import java.util.*;
public class CustomComparator {
    public static void main(String[] args)   {
        Scanner sc = new Scanner(System.in);
        List<Integer> numberList = new ArrayList<>();
        while(sc.hasNextInt()){
            numberList.add(sc.nextInt());
        }
        numberList.stream().sorted(customComparator).forEach(integer -> System.out.print(integer + " "));
    }
    private static Comparator<Integer> customComparator = (first, second) -> {
        if(first%2==0 && second%2!=0){
            return -1;
        }else if(first%2!=0&&second%2==0)  {
            return 1;
        }else{
            return first-second;
        }
    };
}