package ru.aberezhnoy.homework05;

import org.hibernate.Session;
import ru.aberezhnoy.homework05.dao.StudentDao;
import ru.aberezhnoy.homework05.dao.StudentDaoImpl;
import ru.aberezhnoy.homework05.persist.Student;

public class HibernateApp {
    public static void main(String[] args) {

        StudentDao<Student, Long> dao = new StudentDaoImpl();

        try (Session session = SessionFactoryBuilder.getSessionFactory().openSession())
        {
            session.beginTransaction();
            for (int i = 0; i < 1000; i++) {
                session.persist(Student.createStudent()
                        .setName("Student#" + (i + 1))
                        .setMark((int) (Math.random() * 100))
                        .build());
            }
            session.getTransaction().commit();
        }

//        System.out.println(dao.findAll()); // 1000 records
        System.out.println(dao.findById(1000L)); // Optional[{ID: 1000, name: Student#1000, mark: 38}]
        dao.saveOrUpdate(Student
                .createStudent()
                .setName("Student#1001")
                .setMark(1).build());
        dao.findById(1001L);
        Student alex = dao.findById(1001L).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        alex.setName("Alex");
        alex.setMark(1000);
        dao.saveOrUpdate(alex);
        System.out.println(dao.findById(1001L)); // Optional[{ID: 1001, name: Alex, mark: 1000}]
    }
}