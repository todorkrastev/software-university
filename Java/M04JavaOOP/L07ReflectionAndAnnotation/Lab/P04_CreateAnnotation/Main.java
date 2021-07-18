package bg.softuni.java_oop.reflection_and_annotation.lab.P04_CreateAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Subject {
    String[] categories() default "default";
}

@Subject(categories = {"Test", "Annotation"})

public class Main {

}
