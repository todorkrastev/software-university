package com.example.exam.controller;

import com.example.exam.model.binding.UserLoginBindingModel;
import com.example.exam.model.binding.UserRegisterBindingModel;
import com.example.exam.model.service.UserServiceLoginModel;
import com.example.exam.model.service.UserServiceModel;
import com.example.exam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
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
        if (this.userService.isLoggedIn()) {
            return "redirect:/";
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginBindingModel loginModel,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {
        if (this.userService.isLoggedIn()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            return getErrorResponse(loginModel, bindingResult, redirectAttributes);
        }

        if (!this.userService.loginUser(this.mapper.map(loginModel, UserServiceLoginModel.class))) {
            bindingResult.addError(
                    new ObjectError("badCredentials",
                            "Incorrect username or password"));
            return getErrorResponse(loginModel, bindingResult, redirectAttributes);
        }

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        if (!userService.isLoggedIn()) {
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
        if (this.userService.isLoggedIn()) {
            return "redirect:/";
        }

        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterBindingModel registerModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerModel", registerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerModel", bindingResult);
            return "redirect:register";
        }

        this.userService.registerUser(this.mapper.map(registerModel, UserServiceModel.class));

        return "redirect:login";
    }


    @ModelAttribute("loginModel")
    public UserLoginBindingModel initLoginModel() {
        return new UserLoginBindingModel();
    }

    @ModelAttribute("registerModel")
    public UserRegisterBindingModel initRegisterModel() {
        return new UserRegisterBindingModel();
    }
}
