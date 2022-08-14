package softuni.exam.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.exam.model.binding.AlbumBindingModel;
import softuni.exam.model.service.AlbumServiceModel;
import softuni.exam.service.AlbumService;

import javax.validation.Valid;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    public AlbumController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public AlbumBindingModel albumBindingModel() {
        return new AlbumBindingModel();
    }

    @GetMapping("/add")
    public String addAlbum() {
        return "add-album";
    }

    @PostMapping("/add")
    public String addAlbumPost(@Valid AlbumBindingModel albumBindingModel, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("albumBindingModel", albumBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.albumBindingModel", bindingResult);

            return "redirect:add";
        }

        AlbumServiceModel albumServiceModel = modelMapper.map(albumBindingModel, AlbumServiceModel.class);
        albumService.addAlbum(albumServiceModel);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteAlbum(@PathVariable Long id){
        albumService.removeAlbum(id);

        return "redirect:/";
    }
}
