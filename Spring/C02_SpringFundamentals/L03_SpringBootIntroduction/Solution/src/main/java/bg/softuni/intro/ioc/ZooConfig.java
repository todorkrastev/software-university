package bg.softuni.intro.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ZooConfig {

    @Bean("cat")
    public Animal cat(){
        return new Cat();
    }

    @Bean("normalDog")
    public Animal dog(){
        return new Dog();
    }

    @Bean("mySuperDog")
    public Animal superDog(){
        return new Dog(true);
    }
}
