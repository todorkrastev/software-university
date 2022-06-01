package bg.softuni.intro.ioc;

import org.springframework.beans.factory.BeanNameAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Dog implements Animal, BeanNameAware {

    private final boolean isSuperDog;


    public Dog() {
        this(false);
    }

    public Dog(boolean isSuperDog) {
        this.isSuperDog = isSuperDog;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Ready to bark!");
    }

    @Override
    public String makeNoise() {
        return isSuperDog ? "Super Bark bark" : "Bark bark";
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Dog will be destroyed!");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("The name of this bean is: " + name);
    }
}
