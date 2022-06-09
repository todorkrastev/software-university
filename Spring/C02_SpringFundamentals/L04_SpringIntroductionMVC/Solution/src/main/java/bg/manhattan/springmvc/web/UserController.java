package bg.manhattan.springmvc.web;

import bg.manhattan.springmvc.model.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/create")
    public String user() {
        return "create_user";
    }

    @PostMapping("/add")
    public String user(UserDto user, RedirectAttributes redirectAttributes) {
        System.out.println(user);
        redirectAttributes.addAttribute("full-name", user.getFirstName() + " " + user.getLastName());
        return "redirect:/user/created/";
    }

    @GetMapping("/created")
    public String userCreated(@RequestParam("full-name")String fullName, Model model) {
        model.addAttribute("fullName", fullName);
        return "user_created";
    }
}
