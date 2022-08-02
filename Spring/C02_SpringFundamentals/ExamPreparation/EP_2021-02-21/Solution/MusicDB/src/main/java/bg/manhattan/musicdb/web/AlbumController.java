package bg.manhattan.musicdb.web;

import bg.manhattan.musicdb.model.binding.AlbumAddBindingModel;
import bg.manhattan.musicdb.model.service.AlbumServiceModel;
import bg.manhattan.musicdb.model.service.UserServiceModel;
import bg.manhattan.musicdb.service.AlbumService;
import bg.manhattan.musicdb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumService;
    private final UserService userService;
    private final ModelMapper mapper;

    public AlbumController(AlbumService albumService,
                           UserService userService,
                           ModelMapper mapper) {
        this.albumService = albumService;
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping("/add")
    public String add(){
        if (!userService.isLoggedIn()){
            return "redirect:/users/login";
        }
        return "add-album";
    }

    @PostMapping("/add")
    public String add(@Valid AlbumAddBindingModel albumModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("albumModel", albumModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.albumModel", bindingResult );
            return "redirect:add";
        }

        try{
            this.albumService.addAlbum(this.mapper.map(albumModel, AlbumServiceModel.class));
        } catch (IllegalStateException ex){
            bindingResult.addError(
                    new ObjectError("cannotCreateAlbum",
                            ex.getMessage()));
            redirectAttributes.addFlashAttribute("albumModel", albumModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.albumModel", bindingResult );
            return "redirect:add";
        }

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        if (!userService.isLoggedIn()){
            return "redirect:/users/login";
        }
        this.albumService.delete(id);
        return "redirect:/";
    }

    @ModelAttribute("albumModel")
    public AlbumAddBindingModel initAlbum(){
        return new AlbumAddBindingModel();
    }
}
