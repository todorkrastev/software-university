package bg.manhattan.coffeeshop.web;

import bg.manhattan.coffeeshop.model.binding.UserLoginBindingModel;
import bg.manhattan.coffeeshop.model.binding.UserRegisterBindingModel;
import bg.manhattan.coffeeshop.model.service.UserServiceLoginModel;
import bg.manhattan.coffeeshop.model.service.UserServiceModel;
import bg.manhattan.coffeeshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService,
                          ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }



    @GetMapping("/login")
    public String login(Model model){
        if (!model.containsAttribute("notFound")){
            model.addAttribute("notFound", false);
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginBindingModel loginModel,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("loginModel", loginModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginModel",
                    bindingResult);
            return "redirect:login";
        }

        if (!this.userService.login(this.modelMapper.map(loginModel, UserServiceLoginModel.class))){
            redirectAttributes.addFlashAttribute("loginModel", loginModel);
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:login";
        }

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(){
        this.userService.logout();
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterBindingModel registerModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()
                || !registerModel.getPassword().equals(registerModel.getConfirmPassword())) {

            redirectAttributes.addFlashAttribute("registerModel", registerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerModel", bindingResult);

            return "redirect:register";
        }

        this.userService.registerUser(modelMapper.map(registerModel, UserServiceModel.class));

        return "redirect:login";
    }

    @ModelAttribute("loginModel")
    public UserLoginBindingModel initLoginModel() {
        return new UserLoginBindingModel();
    }

    @ModelAttribute("registerModel")
    public UserRegisterBindingModel initRegisterModel()
    {
        return new UserRegisterBindingModel();
    }
}
