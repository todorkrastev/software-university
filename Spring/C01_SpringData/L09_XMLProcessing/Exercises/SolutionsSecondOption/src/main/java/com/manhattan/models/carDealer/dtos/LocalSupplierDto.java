package com.manhattan.models.carDealer.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocalSupplierDto {
    @XmlAttribute(name="id")
    private long id;

    @XmlAttribute(name="name")
    private String name;

    @XmlAttribute(name="parts-count")
    private long partsCount;

    public LocalSupplierDto() {
    }

    public LocalSupplierDto(long id, String name, long partsCount) {
        this.id = id;
        this.name = name;
        this.partsCount = partsCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(long partsCount) {
        this.partsCount = partsCount;
    }
}
