package com.spotifyplaylist.service.impl;

import com.spotifyplaylist.model.entity.Style;
import com.spotifyplaylist.model.entity.Styles;
import com.spotifyplaylist.repo.StyleRepo;
import com.spotifyplaylist.service.StyleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StyleServiceImpl implements StyleService {

    private final StyleRepo repo;

    public StyleServiceImpl(StyleRepo repo) {
        this.repo = repo;
    }

    @Override
    public void initStyles() {
        if (this.repo.count() != 0) {
            return;
        }

        Arrays.stream(Styles.values())
                .forEach(style -> this.repo.save(new Style().setStyleName(style).setDescription("...")));
    }

    @Override
    public Style getStyle(Styles style) {
        return this.repo.findByStyleName(style).orElseThrow();
    }
}
