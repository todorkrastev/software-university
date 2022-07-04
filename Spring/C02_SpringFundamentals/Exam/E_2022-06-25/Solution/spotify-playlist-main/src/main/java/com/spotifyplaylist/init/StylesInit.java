package com.spotifyplaylist.init;

import com.spotifyplaylist.service.StyleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StylesInit implements CommandLineRunner {

    private final StyleService styleService;

    public StylesInit(StyleService styleService) {
        this.styleService = styleService;
    }

    @Override
    public void run(String... args) {
        this.styleService.initStyles();
    }
}
