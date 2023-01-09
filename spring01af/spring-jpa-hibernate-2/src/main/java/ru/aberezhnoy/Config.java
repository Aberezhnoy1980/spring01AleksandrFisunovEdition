package ru.aberezhnoy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.aberezhnoy.dao.CustomerDao;
import ru.aberezhnoy.dao.Dao;
import ru.aberezhnoy.dao.OrderDao;
import ru.aberezhnoy.dao.ProductDao;

@Configuration
@ComponentScan("ru.aberezhnoy")
public class Config {

    @Bean
    public SessionFactoryInit sessionFactoryInit() {
        return new SessionFactoryInit();
    }

    @Bean
    public Dao productDao() {
        return new ProductDao();
    }

    @Bean
    public Dao customerDao() {
        return new CustomerDao();
    }

    @Bean
    public Dao orderDao() {
        return new OrderDao();
    }
}
