package bg.manhattan.springmvc.web;

import bg.manhattan.springmvc.model.AgeCalculationType;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;

@Controller
public class HelloController {
    @GetMapping("/hello/answer/{num}/test")
    public String hello(Model model, @PathVariable(value = "num") @DefaultValue("0") Integer num) {
        model.addAttribute("answer", num);
        model.addAttribute("age1", AgeCalculationType.START_OF_CONTEST.calculateAge(LocalDate.now(),LocalDate.now()));
        model.addAttribute("age2", AgeCalculationType.YEAR_OF_BIRTH.calculateAge(LocalDate.now(),LocalDate.now()));
        model.addAttribute("age3", AgeCalculationType.START_OF_YEAR.calculateAge(LocalDate.now(),LocalDate.now()));
        return "helloworld";
    }
}
