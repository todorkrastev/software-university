package com.manhattan.models.carDealer.dtos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;
@XmlRootElement(name="parts")
public class PartSeedRootDto {

    @XmlElement(name="part")
    private Set<PartSeedDto> parts;

    public PartSeedRootDto() {
        this.parts = new HashSet<>();
    }

    public Set<PartSeedDto> getParts() {
        return parts;
    }
}
