package ru.home.spring_context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class TestBeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

    for(String name: beanDefinitionNames) {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
        System.out.println(beanDefinition.toString());
        }
    }

}
