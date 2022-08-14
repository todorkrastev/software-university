package softuni.exam.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.exam.model.binding.UserLoginBindingModel;
import softuni.exam.model.binding.UserRegisterBindingModel;
import softuni.exam.model.service.UserServiceModel;
import softuni.exam.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @GetMapping("/login")
    public String login(Model model) {

        if (!model.containsAttribute("userNotFound")) {
            model.addAttribute("userNotFound", false);
        }
        if (!model.containsAttribute("invalidUsername")) {
            model.addAttribute("invalidUsername", false);
        }

        if (!model.containsAttribute("invalidPass")) {
            model.addAttribute("invalidPass", false);
        }

        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@Valid UserLoginBindingModel userLoginBindingModel, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            if (bindingResult.hasFieldErrors("username")) {
                redirectAttributes.addFlashAttribute("invalidUsername", true);
            }
            if (bindingResult.hasFieldErrors("password")) {
                redirectAttributes.addFlashAttribute("invalidPass", true);
            }

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
//            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
//                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

            return "redirect:login";
        }

        UserServiceModel userServiceModel = modelMapper.map(userLoginBindingModel, UserServiceModel.class);
        boolean isSuccessful = userService.loginUser(userServiceModel);

        if (!isSuccessful) {
            redirectAttributes.addFlashAttribute("userNotFound", true);
            return "redirect:login";
        }

        return "redirect:/";

    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("register")
    public String registerPost(@Valid UserRegisterBindingModel userRegisterBindingModel,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() ||
                !userRegisterBindingModel.getPassword()
                        .equals(userRegisterBindingModel.getConfirmPassword())) {

            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:register";
        }

        UserServiceModel userServiceModel = modelMapper.map(userRegisterBindingModel, UserServiceModel.class);
        boolean isSuccessful = userService.registerUser(userServiceModel);

        return isSuccessful ? "redirect:login" : "redirect:register";

    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }
}
