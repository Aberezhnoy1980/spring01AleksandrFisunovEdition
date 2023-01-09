package ru.aberezhnoy.homework05;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryBuilder {

    private static volatile SessionFactoryBuilder instance;

    private SessionFactoryBuilder() {
    }

    public static SessionFactoryBuilder getInstance() {
        SessionFactoryBuilder localSessionFactoryBuilder = instance;
        if (localSessionFactoryBuilder == null) {
            synchronized (SessionFactoryBuilder.class) {
                localSessionFactoryBuilder = instance;
                if (localSessionFactoryBuilder == null) {
                    instance = localSessionFactoryBuilder = new SessionFactoryBuilder();
                }
            }
        }
        return localSessionFactoryBuilder;
    }

    public static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }
}
