package com.manhattan.models.carDealer.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name="suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierSeedRootDto {
    @XmlElement(name="supplier")
    private Set<SupplierSeedDto> suppliers;

    public SupplierSeedRootDto() {
        this.suppliers = new HashSet<>();
    }

    public Set<SupplierSeedDto> getSuppliers() {
        return suppliers;
    }
}
