import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Predicate;

public class Inferno {
    private static int[] numberArray;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        numberArray = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashMap<String, Predicate<Integer>> excludes = new HashMap<>();
        String line = "";
        while (!(line = bf.readLine()).equals("Forge")) {
            String[] input = line.split(";");
            String command = input[0];
            String filterType = input[1];
            int filterSum = Integer.parseInt(input[2]);

            Predicate<Integer> currentPredicate = getPredicate(filterType, filterSum);
            switch (command) {
                case "Exclude":
                    excludes.put(filterType + filterSum, currentPredicate);
                    break;
                case "Reverse":
                    excludes.remove(filterType + filterSum);
                    break;
            }
        }
        for (int i =0 ;i<numberArray.length;i++){
            boolean isFiltered = false;
            for(Predicate<Integer> predicate : excludes.values()){
                if(predicate.test(i)){
                    isFiltered = true;
                    break;
                }
            }
            if(!isFiltered){
                System.out.print(numberArray[i] + " ");
            }
        }
    }

    private static Predicate<Integer> getPredicate(String filterType, int filterSum) {
        switch (filterType) {
            case "Sum Left":
                return index -> (index  > 0 ?  numberArray[index - 1] : 0) + //leftNumber
                        numberArray[index] == filterSum; //centerNumber
            case "Sum Right":
                return index -> (index  < numberArray.length - 1 ? numberArray[index + 1] : 0) //rightNumber
                        + numberArray[index] == filterSum; //centerNumber
            case "Sum Left Right":
                return index -> (index > 0 ? numberArray[index - 1] : 0) + //leftNumber
                        (index < numberArray.length - 1 ? numberArray[index + 1] : 0) + //rightNumber
                       numberArray[index] == filterSum; //centerNumber
            default:
                return null;
        }
    }
}

