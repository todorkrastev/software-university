package com.spotifyplaylist.controller.impl;

import com.spotifyplaylist.controller.AuthController;
import com.spotifyplaylist.model.dto.LoginDTO;
import com.spotifyplaylist.model.dto.RegisterDTO;
import com.spotifyplaylist.service.AuthService;
import com.spotifyplaylist.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthControllerImpl implements AuthController {

    private final LoggedUser loggedUser;
    private final AuthService authService;

    public AuthControllerImpl(LoggedUser loggedUser, AuthService authService) {
        this.loggedUser = loggedUser;
        this.authService = authService;
    }

    @Override
    public String login(Model model) {
        if (this.loggedUser.isLogged()) {
            return "redirect:/home";
        }

        return "login";
    }

    @Override
    public String loginConfirm(LoginDTO loginDTO, BindingResult result, RedirectAttributes redirectAttributes) {
        if (this.loggedUser.isLogged()) {
            return "redirect:/home";
        }

        if (result.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("loginDTO", loginDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.loginDTO", result);

            return "redirect:/users/login";
        }

        boolean validCredentials = this.authService.checkCredentials(loginDTO.getUsername(), loginDTO.getPassword());

        if (!validCredentials) {
            redirectAttributes
                    .addFlashAttribute("loginDTO", loginDTO)
                    .addFlashAttribute("validCredentials", false);
            return "redirect:/users/login";
        }

        this.authService.login(loginDTO.getUsername());
        return "redirect:/home";
    }

    @Override
    public String register() {
        if (this.loggedUser.isLogged()) {
            return "redirect:/home";
        }

        return "register";
    }

    @Override
    public String registerConfirm(RegisterDTO registerDTO, BindingResult result, RedirectAttributes redirectAttributes) {
        if (this.loggedUser.isLogged()) {
            return "redirect:/home";
        }

        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            result.addError(
                    new FieldError(
                            "differentConfirmPassword",
                            "confirmPassword",
                            "Passwords must be the same."));
        }

        if (result.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("registerDTO", registerDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.registerDTO", result);

            return "redirect:/users/register";
        }

        this.authService.register(registerDTO);
        return "redirect:/home";
    }

    @Override
    public String logout() {
        if (!this.loggedUser.isLogged()) {
            return "login";
        }

        this.authService.logout();
        return "redirect:/users/login";
    }

    @ModelAttribute
    public LoginDTO loginDTO() {
        return new LoginDTO();
    }

    @ModelAttribute
    public RegisterDTO registerDTO() {
        return new RegisterDTO();
    }

    @ModelAttribute
    public void addAttribute(Model model) {
        model.addAttribute("validCredentials");
    }
}
