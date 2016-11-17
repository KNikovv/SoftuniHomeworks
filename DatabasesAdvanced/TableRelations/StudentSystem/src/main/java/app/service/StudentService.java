package app.service;

import app.entities.Student;

public interface StudentService {

    void save(Student student);

    Iterable<Student> findAll();
}
