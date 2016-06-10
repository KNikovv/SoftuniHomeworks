package Repository;

import IO.OutputWriter;
import StaticData.ExceptionMessages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Predicate;

public class RepositoryFilters {
    public static void printFilteredStudents(HashMap<String, ArrayList<Integer>> courseData,
                                             String filterType,
                                             Integer numberOfStudents) {
        Predicate<Double> filter = createFilter(filterType);
        filterAndTake(filter,courseData,numberOfStudents);
    }

    private static void filterAndTake(Predicate<Double> filter, HashMap<String, ArrayList<Integer>> courseData, int numberOfStudents) {
        if (filter == null) {
            OutputWriter.displayException(ExceptionMessages.INVALID_FILTER);
            return;
        }
        int studentscount = 0;
        for (String student : courseData.keySet()) {
            if (studentscount == numberOfStudents) {
                break;
            }
            ArrayList<Integer> studentsMarks = courseData.get(student);
            Double averageMark = studentsMarks.stream().mapToInt(Integer::valueOf).average().getAsDouble();
            Double percentageOfFullfilment = averageMark/100;
            Double mark = percentageOfFullfilment * 4 + 2;
            if (filter.test(mark)) {
                OutputWriter.printStudent(student, studentsMarks);
                studentscount++;
            }
        }

    }



    private static Predicate<Double> createFilter(String filterType) {
        switch (filterType) {
            case "excellent":
                return mark -> mark >= 5.00;
            case "average":
                return mark -> mark >= 3.50 && mark <= 5.00;
            case "poor":
                return mark -> mark < 3.50;
            default:
                return null;
        }
    }
}
