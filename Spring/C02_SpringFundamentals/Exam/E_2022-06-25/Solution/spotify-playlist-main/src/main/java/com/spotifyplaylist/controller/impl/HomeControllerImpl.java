package com.spotifyplaylist.controller.impl;

import com.spotifyplaylist.controller.HomeController;
import com.spotifyplaylist.model.dto.SongDTO;
import com.spotifyplaylist.model.dto.SongsByGenreDTO;
import com.spotifyplaylist.service.HomeService;
import com.spotifyplaylist.service.SongService;
import com.spotifyplaylist.service.UserService;
import com.spotifyplaylist.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Set;

@Controller
public class HomeControllerImpl implements HomeController {

    private final LoggedUser loggedUser;
    private final HomeService homeService;
    private final SongService songService;
    private final UserService userService;

    public HomeControllerImpl(LoggedUser loggedUser, HomeService homeService,
                              SongService songService, UserService userService) {
        this.loggedUser = loggedUser;
        this.homeService = homeService;
        this.songService = songService;
        this.userService = userService;
    }

    @Override
    public String index() {
        if (loggedUser.isLogged()) {
            return "redirect:/home";
        }

        return "index";
    }

    @Override
    public String home(Model model) {
        if (!loggedUser.isLogged()) {
            return "redirect:/";
        }

        Set<SongDTO> playlist = this.songService.getPlaylist(loggedUser.getId());
        String totalDurationOfPlaylist = this.calcTotalDuration(playlist);

        model
                .addAttribute("songs", this.homeService.getSongs())
                .addAttribute("playlist", playlist)
                .addAttribute("totalDurationOfPlaylist", totalDurationOfPlaylist);

        return "home";
    }

    @Override
    public String addSongToPlaylist(Long id) {
        if (!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        this.userService.addSongToUser(id, this.loggedUser.getId());
        return "redirect:/home";
    }

    @Override
    public String removeSongFromPlaylist(Long id) {
        if (!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        this.userService.removeSongFromUser(id, this.loggedUser.getId());
        return "redirect:/home";
    }

    @Override
    public String deleteAllFromPlaylist() {
        if (!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        this.userService.deleteAllSongs(this.loggedUser.getId());
        return "redirect:/home";
    }

    private String calcTotalDuration(Set<SongDTO> playlist) {
        int sumSeconds = playlist.stream().mapToInt(SongDTO::getDuration).sum();
        int minutes = (int) Math.floor(sumSeconds / 60.0);
        int seconds = sumSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    @ModelAttribute
    public SongsByGenreDTO songs() {
        return new SongsByGenreDTO();
    }
}
