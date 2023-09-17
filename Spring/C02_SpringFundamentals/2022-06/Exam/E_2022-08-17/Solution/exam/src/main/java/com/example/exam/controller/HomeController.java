package com.example.exam.controller;

import com.example.exam.model.view.CurrentUserPostView;
import com.example.exam.model.view.HomeViewModel;
import com.example.exam.model.view.OtherUserPostView;
import com.example.exam.service.PostService;
import com.example.exam.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class HomeController {
    private final UserService userService;
    private final PostService postService;

    public HomeController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }


    @GetMapping("/")
    public String index(Model model) {
        if (this.userService.isLoggedIn()) {
            try {
                prepareData(model);
            } catch (IllegalArgumentException ex) {
                return "index";
            }
            return "home";
        }

        return "index";
    }

    private void prepareData(Model model) {
        if (!model.containsAttribute("homeModel")) {
            HomeViewModel homeModel = new HomeViewModel();

            List<CurrentUserPostView> currUser = this.postService.findAllByIdAndUsernameAndMoodAndLikesAndContent();

            String username = this.userService.getCurrentUser().getUsername();
            homeModel.setCurrUserUsername(username);

            List<CurrentUserPostView> filtered = currUser
                    .stream()
                    .filter(currentUserPostView -> currentUserPostView.getUsername().equals(username))
                    .collect(Collectors.toList());
            homeModel.setCurrUserPosts(filtered);

            List<OtherUserPostView> otherPosts = this.postService.findAllOtherUsersPosts();
            List<OtherUserPostView> filteredOthers = otherPosts
                    .stream()
                    .filter(currentUserPostView -> !currentUserPostView.getUsername().equals(username))
                    .collect(Collectors.toList());

            homeModel.setOtherPosts(filteredOthers);


            model.addAttribute("homeModel", homeModel);
        }
    }
}
