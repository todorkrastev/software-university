package bg.manhattan.gira.web;

import bg.manhattan.gira.model.binding.UserLoginBindingModel;
import bg.manhattan.gira.model.binding.UserRegisterBindingModel;
import bg.manhattan.gira.model.service.UserServiceLoginModel;
import bg.manhattan.gira.model.service.UserServiceModel;
import bg.manhattan.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
    private final ModelMapper mapper;

    public UserController(UserService userService, ModelMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginBindingModel loginModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return getErrorResponse(loginModel, bindingResult, redirectAttributes);
        }

        if (!this.userService.loginUser(this.mapper.map(loginModel, UserServiceLoginModel.class))){
            bindingResult.addError(
                    new ObjectError("badCredentials",
                            "Incorrect email or password"));
            return getErrorResponse(loginModel, bindingResult, redirectAttributes);
        }

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        if (!userService.isLoggedIn()){
            return "redirect:/users/login";
        }
        this.userService.logout();
        return "redirect:/";
    }

    private String getErrorResponse(UserLoginBindingModel loginModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("loginModel", loginModel);
        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginModel", bindingResult);
        return "redirect:login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterBindingModel registerModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerModel", registerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerModel", bindingResult );
            return "redirect:register";
        }

        this.userService.registerUser(this.mapper.map(registerModel, UserServiceModel.class));
        return "redirect:/";
    }

    @ModelAttribute("loginModel")
    public UserLoginBindingModel initLoginModel(){
        return new UserLoginBindingModel();
    }

    @ModelAttribute("registerModel")
    public UserRegisterBindingModel initRegisterModel(){
        return new UserRegisterBindingModel();
    }

}
