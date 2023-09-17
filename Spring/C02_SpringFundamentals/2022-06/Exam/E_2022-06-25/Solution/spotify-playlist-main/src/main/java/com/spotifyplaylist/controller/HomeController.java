package com.spotifyplaylist.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(name = "/")
public interface HomeController {

    @GetMapping
    String index();

    @GetMapping("/home")
    String home(Model model);

    @GetMapping("/home/add-song/{id}")
    String addSongToPlaylist(@PathVariable("id") Long id);

    @GetMapping("/home/remove-song/{id}")
    String removeSongFromPlaylist(@PathVariable("id") Long id);

    @GetMapping("/home/remove-all-song")
    String deleteAllFromPlaylist();
}
