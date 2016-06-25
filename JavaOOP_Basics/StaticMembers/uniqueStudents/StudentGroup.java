package uniqueStudents;

import java.util.ArrayList;

public class StudentGroup {
    static int uniqueCounter;
    ArrayList<Student> allStudents;

     StudentGroup() {
        this.allStudents = new ArrayList<>();
    }
    public void addStudent(Student student){
        boolean isContained = false;
        for(Student student1 : this.allStudents){
            if(student1.getName().equals(student.getName())){
                isContained = true;
            }
        }
        if(!isContained){
            uniqueCounter++;
        }
        this.allStudents.add(student);
    }
}

