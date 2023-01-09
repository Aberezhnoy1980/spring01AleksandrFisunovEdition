package ru.aberezhnoy.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.aberezhnoy.SessionFactoryInit;
import ru.aberezhnoy.persist.Product;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

@Repository
public class ProductDao implements Dao<Product, Long> {

    private SessionFactoryInit factory;

    @Autowired
    public void setSessionFactoryInit(SessionFactoryInit factory) {
        this.factory = factory;
    }

    @Override
    public List<Product> findAll() {
        return executeForSession(
                session -> session.createQuery("select p from Product p", Product.class)
                        .getResultList()
        );
    }

    @Override
    public Optional<Product> findById(Long id) {
        return executeForSession(
                session -> Optional.ofNullable(session.find(Product.class, id))
        );
    }

    @Override
    public Product saveOrUpdate(Product product) {
        executeInTransaction(session -> {
            if (product.getId() == null) {
                session.persist(product);
            } else {
                session.merge(product);
            }
        });
        return product;
    }

    @Override
    public void deleteById(Long id) {
        executeInTransaction(
                session -> session.createQuery("delete from Product where id =:id")
                        .setParameter("id", id)
                        .executeUpdate()
        );

    }

    public void printById(Long id) {
        try (Session session = factory.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            System.out.println(product);
            session.getTransaction().commit();
        }
    }

    private <R> R executeForSession(Function<Session, R> function) {
        try (Session session = factory.getSessionFactory().openSession()) {
//            session.beginTransaction();
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
