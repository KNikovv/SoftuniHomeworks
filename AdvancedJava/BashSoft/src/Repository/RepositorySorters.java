package Repository;

import IO.OutputWriter;

import java.util.*;
import java.util.stream.Collectors;

public class RepositorySorters {
    public static void printSortedStudents(HashMap<String, ArrayList<Integer>> courseData, String comparisonType,
                                           int numberOfstudents) {

        Comparator<Map.Entry<String, ArrayList<Integer>>> comparator = (x,y) ->
                Double.compare(
                        x.getValue().stream().mapToInt(Integer::valueOf).average().getAsDouble(),
                        y.getValue().stream().mapToInt(Integer::valueOf).average().getAsDouble());
        List<String> sortedStudents = courseData.entrySet().stream()
                .sorted(comparator)
                .limit(numberOfstudents)
                .map(x -> x.getKey())
                .collect(Collectors.toList());
        if(comparisonType.equals("descending")){
            Collections.reverse(sortedStudents);
        }
        sortedStudents.stream().forEach(s -> OutputWriter.printStudent(s,courseData.get(s)));
    }
}
