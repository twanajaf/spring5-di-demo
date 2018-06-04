package guru.springframework;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements InitializingBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware, DisposableBean {
    public LifeCycleDemoBean() {
        System.out.println("## I am in the LifeCycleDemoBean constructor");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## Bean Factory has been set");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## The LifeCycleDemoBean has its properties set!");
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("## My bean name is: "+ beanName);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## The LifeCycleDemoBean has bean terminated");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## ApplicationContext has been set");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("## The PostConstruct annotated method has been called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("## The PreConstruct annotated method has been called");
    }

    public void beforeInit() {
        System.out.println("## - Before init- Called by Bean Post processor");
    }

    public void afterInit() {
        System.out.println("## - After init- Called by Bean Post Processor");
    }
}
