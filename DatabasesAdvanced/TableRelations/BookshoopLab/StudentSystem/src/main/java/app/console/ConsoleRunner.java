package app.console;

import app.entities.Course;
import app.entities.Homework;
import app.entities.Resource;
import app.entities.Student;
import app.entities.enums.ContentType;
import app.entities.enums.ResourceType;
import app.service.CourseService;
import app.service.HomeworkService;
import app.service.ResourceService;
import app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private CourseService courseService;
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private StudentService studentService;

    private static Random random = new Random();
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");


    @Override
    public void run(String... strings) throws Exception {

       // this.seedDatabase();

        // findAllStudentsWithHomeworks();

        // printAllCoursesOrdered();


    }

    private void printAllCoursesOrdered() {
        Iterable<Course> courses = this.courseService.findAllOrderedByStartDateThenByEndDate();

        for (Course course : courses) {
            System.out.printf("%s %s\n", course.getName(), course.getStartDate());
        }
    }

    private void findAllStudentsWithHomeworks() {
        Iterable<Student> students = this.studentService.findAll();

        for (Student student : students) {
            System.out.printf("Student: %s \n", student.getName());
            System.out.println(student.getHomeworks().size() > 0 ? "Homeworks----" : "No homeworks");
            for (Homework homework : student.getHomeworks()) {
                System.out.printf("Content - %s, Type - %s\n", homework.getContent(), homework.getContentType());
            }
        }
    }

    private void seedDatabase() throws IOException, ParseException {
        List<Course> courses = this.seedCourses();
        List<Student> students = this.seedStudents(courses);
        this.seedHomeworks(courses, students);
        this.seedResources(courses);
    }

    private void seedResources(List<Course> courses) throws IOException {
        BufferedReader resourceReader = new BufferedReader(new FileReader("res/resources.txt"));
        String line;

        while ((line = resourceReader.readLine()) != null) {
            String[] data = line.split("\\s+");

            String name = data[0];
            ResourceType resourceType = ResourceType.valueOf(data[1]);
            String url = data[2];
            int courseIndex = random.nextInt(courses.size());
            Course course = courses.get(courseIndex);

            Resource resource = new Resource(name, resourceType, url);
            resource.setCourse(course);
            this.resourceService.save(resource);
        }
    }

    private void seedHomeworks(List<Course> courses, List<Student> students) throws IOException, ParseException {
        BufferedReader homeworkReader = new BufferedReader(new FileReader("res/homeworks.txt"));
        String line;
        while ((line = homeworkReader.readLine()) != null) {
            String[] data = line.split("\\s+");

            String name = data[0];
            ContentType contentType = ContentType.valueOf(data[1]);
            Date submissionDate = formatter.parse(data[2]);
            int courseIndex = random.nextInt(courses.size());
            int studentIndex = random.nextInt(students.size());
            Course course = courses.get(courseIndex);
            Student student = students.get(studentIndex);

            Homework homework = new Homework(name, contentType, submissionDate);
            homework.setCourse(course);
            homework.setStudent(student);
            this.homeworkService.save(homework);
        }
    }

    private List<Course> seedCourses() throws IOException, ParseException {
        BufferedReader courseReader = new BufferedReader(new FileReader("res/courses.txt"));
        String line;
        List<Course> courses = new LinkedList<>();
        while ((line = courseReader.readLine()) != null) {
            String[] data = line.split("\\s+");

            String courseName = data[0];
            Date startDate = formatter.parse(data[1]);
            Date endDate = formatter.parse(data[2]);
            BigDecimal price = new BigDecimal(data[3]);

            Course course = new Course(courseName, startDate, endDate, price);
            this.courseService.save(course);
            courses.add(course);
        }

        return courses;
    }

    private List<Student> seedStudents(List<Course> courses) throws IOException, ParseException {
        BufferedReader studentReader = new BufferedReader(new FileReader("res/students.txt"));
        String line;
        List<Student> students = new LinkedList<>();
        while ((line = studentReader.readLine()) != null) {
            String[] data = line.split("\\s+");

            String name = data[0];
            String phoneNumber = data[1];
            Date regDate = formatter.parse(data[2]);
            Date birthday = formatter.parse(data[3]);
            int courseIndex = random.nextInt(courses.size());
            Course course = courses.get(courseIndex);

            Student student = new Student(name, phoneNumber, regDate, birthday);
            student.getCourses().add(course);
            this.studentService.save(student);
            students.add(student);
        }

        return students;
    }
}
