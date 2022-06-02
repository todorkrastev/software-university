package bg.softuni.intro.cats.design_pattern.speciffication.impl;

import bg.softuni.intro.ioc.Cat;
import bg.softuni.intro.ioc.Dog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DogVoiceServiceTest {

    private DogFeedHandler handler;

    public DogVoiceServiceTest(){
        handler = new DogFeedHandler();
    }

    @Test
    public void can_handle_dog_true(){
        //arrange
        Dog dog = new Dog().setName("Pesho");

        //act & assert
        assertTrue(this.handler.canHandle(dog));
    }

    @Test
    public void can_handle_cat_false(){
        //arrange
        Cat cat = new Cat().setName("Pissy");

        //act & assert
        assertFalse(this.handler.canHandle(cat));
    }



}
