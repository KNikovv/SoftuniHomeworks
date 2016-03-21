import java.io.*;

/**
 * Created by kaloy on 3/2/2016.
 */
public class SaveCustomObject {

    public static void main(String[] args) {
        Course thisCourse = new Course();
        thisCourse.name = "Math";
        thisCourse.students = 40;
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("resources/course.save"))) {

            output.writeObject(thisCourse);
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("resources/courses.save"))) {
Course newcrs = new Course();
            newcrs = (Course) input.readObject();

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } catch(ClassNotFoundException ex){

        }
        System.out.println(thisCourse);
    }
}

class Course implements Serializable {
    String name;
    int students;
    public String toString() {
        return this.name + " course has " + this.students + " students.";
    }
}
