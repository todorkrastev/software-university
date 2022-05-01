package com.example.football.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "players")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerSeedRootDto {

    @XmlElement(name="player")
    private final List<PlayerSeedDto> players;

    public PlayerSeedRootDto() {
        this.players = new ArrayList<>();
    }

    public List<PlayerSeedDto> getPlayers() {
        return players;
    }
}
