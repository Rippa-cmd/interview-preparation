package ru.geekbrains;

import ru.geekbrains.entity.Student;
import ru.geekbrains.DAO.StudentDAO;
import ru.geekbrains.DAO.StudentDAOImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Student student;
        StudentDAO studentDAO = new StudentDAOImpl();
        for (int i = 1; i <= 1000; i++) {
            student = new Student("Student" + i, i);
            studentDAO.addStudent(student);
        }

        student = studentDAO.getStudentById(10L);
        student.setName("Poll");
        studentDAO.updateStudent(student);

        studentDAO.deleteStudent(student);
    }
}
