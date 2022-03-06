package ru.home.spring_context;

import org.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MainApp {
    public static void main(String[] args) {
        TestBeanFactoryPostProcessor beanList = new TestBeanFactoryPostProcessor();

//        beanList.postProcessBeanFactory();

         final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap();
        System.out.println(beanDefinitionMap);
    }
}
