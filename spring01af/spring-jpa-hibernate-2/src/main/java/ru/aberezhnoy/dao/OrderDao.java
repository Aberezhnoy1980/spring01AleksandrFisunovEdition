package ru.aberezhnoy.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.aberezhnoy.SessionFactoryInit;
import ru.aberezhnoy.persist.Order;
import ru.aberezhnoy.persist.Product;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

@Repository
public class OrderDao implements Dao<Order, Long> {

    private SessionFactoryInit factory;

    @Autowired
    public void setOrderDao(SessionFactoryInit factory) {
        this.factory = factory;
    }

    @Override
    public List<Order> findAll() {
        return executeForSession(
                session -> session.createQuery("select o from Order o", Order.class)
                        .getResultList()
        );
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Order saveOrUpdate(Order obj) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    private <R> R executeForSession(Function<Session, R> function) {
        try (Session session = factory.getSessionFactory().openSession()) {
            return function.apply(session);
        }
    }

    private void executeInTransaction(Consumer<Session> consumer) {
        Session session = factory.getSessionFactory().getCurrentSession();
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
}
