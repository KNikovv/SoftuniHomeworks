package app.service;

import app.entities.Course;
import app.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void save(Course course) {
        this.courseRepository.save(course);
    }

    @Override
    public Iterable<Course> findAllOrderedByStartDateThenByEndDate() {
        return this.courseRepository.findAllByOrderByStartDateAscEndDateDesc();
    }


}
