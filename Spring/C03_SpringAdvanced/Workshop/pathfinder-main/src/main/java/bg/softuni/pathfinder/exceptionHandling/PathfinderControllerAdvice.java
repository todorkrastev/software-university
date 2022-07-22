package bg.softuni.pathfinder.exceptionHandling;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PathfinderControllerAdvice {
    @ExceptionHandler({Exception.class})
    public String handleError() {
        return "redirect:error";
    }
}
