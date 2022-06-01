package bg.softuni.intro.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZooService {
//    private final Animal animal;
//
//    public ZooService(@Qualifier("mySuperDog") Animal animal) {
//        this.animal = animal;
//    }
//    public void doWork(){
//        System.out.println(this.animal.makeNoise());
//    }
    private List<Animal> animals;

    public ZooService(List<Animal> animals) {
        this.animals = animals;
    }


    public void doWork(){
        this.animals.stream()
                .map(Animal::makeNoise)
                .forEach(System.out::println);
    }
}
