package ru.geekbrains.service;

import ru.geekbrains.persist.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Optional<Student> findById(long id);

    List<Student> findAll();

    void delete(Long id);

    void save(Student student);

    void edit(Student student);

}
