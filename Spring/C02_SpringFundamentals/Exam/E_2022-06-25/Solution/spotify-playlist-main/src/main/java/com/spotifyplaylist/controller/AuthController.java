package com.spotifyplaylist.controller;

import com.spotifyplaylist.model.dto.LoginDTO;
import com.spotifyplaylist.model.dto.RegisterDTO;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RequestMapping("/users")
public interface AuthController {

    @GetMapping("/login")
    String login(Model model);

    @PostMapping("/login")
    String loginConfirm(@Valid LoginDTO loginDTO, BindingResult result, RedirectAttributes redirectAttributes);

    @GetMapping("/register")
    String register();

    @PostMapping("/register")
    String registerConfirm(@Valid RegisterDTO registerDTO, BindingResult result, RedirectAttributes redirectAttributes);

    @PostMapping("/logout")
    String logout();
}
