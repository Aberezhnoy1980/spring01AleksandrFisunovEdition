package ru.aberezhnoy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.aberezhnoy.dao.Dao;
import ru.aberezhnoy.dao.ProductDao;

@Configuration
@ComponentScan("ru.aberezhnoy")
public class Config {

    @Bean
    public SessionFactoryInit sessionFactoryInit() {
        return new SessionFactoryInit();
    }

    @Bean
    public ProductDao productDao() {
        return new ProductDao();
    }

}
