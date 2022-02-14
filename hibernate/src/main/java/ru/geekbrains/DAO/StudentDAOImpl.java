package ru.geekbrains.DAO;

import org.hibernate.Session;
import ru.geekbrains.utils.HibernateUtil;
import ru.geekbrains.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StudentDAOImpl implements StudentDAO{

    private Session session;

    @Override
    public void addStudent(Student student) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();
        closeSession();
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(student);
        session.getTransaction().commit();
        closeSession();
    }

    @Override
    public Student getStudentById(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        closeSession();
        return student;
    }

    @Override
    public Collection<Student> getAllStudents() throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Student> students = new ArrayList<>();
        students = (List<Student>) session.createQuery("From Student").list();
        closeSession();
        return students;
    }

    @Override
    public void deleteStudent(Student student) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();
        closeSession();
    }

    private void closeSession() {
        session.close();
    }
}
