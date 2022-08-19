package com.example.exam.controller;

import com.example.exam.model.binding.PostBindingModel;
import com.example.exam.model.service.PostServiceModel;
import com.example.exam.service.PostService;
import com.example.exam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final UserService userService;
    private final PostService postService;
    private final ModelMapper mapper;

    public PostController(UserService userService, PostService postService, ModelMapper mapper) {
        this.userService = userService;
        this.postService = postService;
        this.mapper = mapper;
    }

    @GetMapping("/add")
    public String add(){
        if (!this.userService.isLoggedIn()){
            return "redirect:/users/login";
        }

        return "post-add";
    }

    @PostMapping("/add")
    public String add(@Valid PostBindingModel postModel,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        if (!this.userService.isLoggedIn()){
            return "redirect:/users/login";
        }

        if (bindingResult.hasErrors()) {
            return getErrorResponse(postModel, bindingResult, redirectAttributes);
        }
        try {
            this.postService.addPost(this.mapper.map(postModel, PostServiceModel.class));
        } catch (IllegalArgumentException ex) {
            ObjectError error = new ObjectError("globalError", ex.getMessage());
            bindingResult.addError(error);
            return getErrorResponse(postModel, bindingResult, redirectAttributes);
        }
        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String removeAll(@PathVariable Long id) {
        if (!userService.isLoggedIn()){
            return "redirect:/users/login";
        }

        this.postService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/likes/{id}")
    public String likes(@PathVariable Long id) {
        if (!userService.isLoggedIn()){
            return "redirect:/users/login";
        }

        this.postService.addLikeById(id);
        return "redirect:/";
    }

    private String getErrorResponse(PostBindingModel postModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("postModel", postModel);
        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.postModel", bindingResult);
        return "redirect:add";
    }


    @ModelAttribute("postModel")
    public PostBindingModel initPost(){
        return new PostBindingModel();
    }
}
