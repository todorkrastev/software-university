package com.spotifyplaylist.controller.impl;

import com.spotifyplaylist.controller.SongController;
import com.spotifyplaylist.model.dto.AddSongDTO;
import com.spotifyplaylist.service.SongService;
import com.spotifyplaylist.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongControllerImpl implements SongController {

    private final LoggedUser loggedUser;
    private final SongService songService;

    public SongControllerImpl(LoggedUser loggedUser, SongService songService) {
        this.loggedUser = loggedUser;
        this.songService = songService;
    }

    @Override
    public String addSong() {
        if (!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        return "song-add";
    }

    @Override
    public String addSong(AddSongDTO addSongDTO, BindingResult result, RedirectAttributes redirectAttributes) {
        if (!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        if (result.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("addSongDTO", addSongDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addSongDTO", result);

            return "redirect:/songs/add-song";
        }

        this.songService.addSong(addSongDTO);
        return "redirect:/home";
    }

    @ModelAttribute
    public AddSongDTO addSongDTO() {
        return new AddSongDTO();
    }
}
