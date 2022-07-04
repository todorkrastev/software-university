package com.spotifyplaylist.service;

import com.spotifyplaylist.model.entity.Style;
import com.spotifyplaylist.model.entity.Styles;

public interface StyleService {

    void initStyles();

    Style getStyle(Styles style);
}
