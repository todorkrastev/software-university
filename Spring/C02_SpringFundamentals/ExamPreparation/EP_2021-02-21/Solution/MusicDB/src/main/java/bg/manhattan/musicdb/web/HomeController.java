package bg.manhattan.musicdb.web;

import bg.manhattan.musicdb.model.view.HomeViewModel;
import bg.manhattan.musicdb.service.AlbumService;
import bg.manhattan.musicdb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final UserService userService;
    private final AlbumService albumService;


    public HomeController(UserService userService,
                          AlbumService albumService) {
        this.userService = userService;
        this.albumService = albumService;
    }

    @GetMapping("/")
    public String index(Model model) {
        if (this.userService.isLoggedIn()) {
            if (!model.containsAttribute("homeModel")) {
                HomeViewModel homeViewModel = new HomeViewModel(this.albumService.getAlbums());
                model.addAttribute("homeModel", homeViewModel);
            }
            return "home";
        }

        return "index";
    }
}
