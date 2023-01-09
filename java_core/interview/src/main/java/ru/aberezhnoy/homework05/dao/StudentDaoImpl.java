package ru.aberezhnoy.homework05.dao;

import org.hibernate.Session;
import ru.aberezhnoy.homework05.SessionFactoryBuilder;
import ru.aberezhnoy.homework05.persist.Student;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class StudentDaoImpl implements StudentDao<Student, Long> {

    @Override
    public List<Student> findAll() {
        return executeForSession(
                session -> session.createQuery("select s from Student s", Student.class)
                        .getResultList()
        );
    }

    @Override
    public Optional<Student> findById(Long id) {
        return executeForSession(
                session -> Optional.ofNullable(session.find(Student.class, id))
        );
    }

    @Override
    public void deleteById(Long id) {
        executeInTransaction(
                session -> session.createQuery("delete from Student where id =:id")
                        .setParameter("id", id)
                        .executeUpdate()
        );
    }

    @Override
    public Student saveOrUpdate(Student student) {
        executeInTransaction(session -> {
            if (student.getId() == null) {
                session.persist(student);
            } else {
                session.merge(student);
            }
        });
        return student;
    }

    private void executeInTransaction(Consumer<Session> consumer) {
        Session session = SessionFactoryBuilder.getInstance().getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            consumer.accept(session);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private <R> R executeForSession(Function<Session, R> function) {
        try (Session session = SessionFactoryBuilder.getInstance().getSessionFactory().openSession()) {
            return function.apply(session);
        }
    }
}
