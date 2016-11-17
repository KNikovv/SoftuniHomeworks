package app.service;

import app.entities.Course;

public interface CourseService {

    void save(Course course);

    Iterable<Course> findAllOrderedByStartDateThenByEndDate();
}
