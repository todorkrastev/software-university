package bg.manhattan.gira.web;

import bg.manhattan.gira.model.view.HomeViewModel;
import bg.manhattan.gira.service.TaskService;
import bg.manhattan.gira.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final UserService userService;
    private final TaskService taskService;

    public HomeController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index(Model model) {
        if (this.userService.isLoggedIn()) {
            if (!model.containsAttribute("homeModel")) {
                HomeViewModel homeViewModel = new HomeViewModel(this.taskService.getTasks());
                model.addAttribute("homeModel", homeViewModel);
            }
            return "home";
        }

        return "index";
    }
}
