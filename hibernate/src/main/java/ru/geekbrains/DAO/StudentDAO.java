package ru.geekbrains.DAO;

import ru.geekbrains.entity.Student;

import java.util.Collection;
import java.sql.SQLException;

public interface StudentDAO {
    void addStudent(Student student) throws SQLException;
    void updateStudent(Student student) throws SQLException;
    Student getStudentById(Long id) throws SQLException;
    Collection<Student> getAllStudents() throws SQLException;
    void deleteStudent(Student student) throws SQLException;

}
