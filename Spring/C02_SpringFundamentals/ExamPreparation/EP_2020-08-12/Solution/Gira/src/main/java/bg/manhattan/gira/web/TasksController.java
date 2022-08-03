package bg.manhattan.gira.web;

import bg.manhattan.gira.model.binding.TaskAddBindingModel;
import bg.manhattan.gira.model.service.TaskServiceModel;
import bg.manhattan.gira.service.TaskService;
import bg.manhattan.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TasksController {
    private final TaskService taskService;
    private final UserService userService;

    private final ModelMapper mapper;

    public TasksController(TaskService taskService,
                           UserService userService,
                           ModelMapper mapper) {
        this.taskService = taskService;
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping("/add")
    public String add() {
        if (!userService.isLoggedIn()) {
            return "redirect:/users/login";
        }
        return "add-task";
    }

    @PostMapping("/add")
    public String add(@Valid TaskAddBindingModel taskModel,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("taskModel", taskModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskModel", bindingResult);
            return "redirect:add";
        }

        try {
            this.taskService.add(this.mapper.map(taskModel, TaskServiceModel.class));
        } catch (IllegalArgumentException ex) {
            bindingResult.addError(new ObjectError("cannotRegisterTask", ex.getMessage()));
            redirectAttributes.addFlashAttribute("taskModel", taskModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskModel", bindingResult);
            return "redirect:add";
        }
        return "redirect:/";
    }

    @GetMapping("/progress/{id}")
    public String progress(@PathVariable Long id) {
        if (!userService.isLoggedIn()) {
            return "redirect:/users/login";
        }
        try {
            this.taskService.progress(id);
        } catch (IllegalArgumentException | IllegalStateException ex){
            // TODO: 22.6.2022 г. log exception
        }

        return "redirect:/";
    }

    @ModelAttribute("taskModel")
    public TaskAddBindingModel initTask() {
        return new TaskAddBindingModel();
    }


}
