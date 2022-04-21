package com.manhattan.models.carDealer.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocalSupplierRootDto {

    @XmlElement(name = "supplier")
    private List<LocalSupplierDto> suppliers;

    public LocalSupplierRootDto(List<LocalSupplierDto> suppliers) {
        this.suppliers = suppliers;
    }

    public LocalSupplierRootDto() {
    }
}
