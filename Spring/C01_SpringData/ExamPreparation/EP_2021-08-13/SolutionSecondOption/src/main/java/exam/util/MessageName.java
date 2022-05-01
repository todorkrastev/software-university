package exam.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MessageName {

    /**
     * Sets entity name to be used for alter naming during creation of log messages
     * @return entity name assigned to the Dto
     * @author Nikolay Kostadinov
     */
    String name() default "##default";
}
