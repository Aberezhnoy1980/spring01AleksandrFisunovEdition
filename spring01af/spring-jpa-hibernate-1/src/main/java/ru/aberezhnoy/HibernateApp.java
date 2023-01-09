package ru.aberezhnoy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.aberezhnoy.dao.ProductDao;


public class HibernateApp {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        ProductDao productDao = context.getBean(ProductDao.class);


        System.out.println(productDao.findById(1L));

        productDao.printById(5L);

//        productDao.saveOrUpdate(new Product("somethingelse", BigDecimal.valueOf(500.00)));
//        productDao.printById(8L);
//        productDao.deleteById(8L);

        System.out.println(productDao.findAll());
    }
}
