package hiberspring.domain.dtos;

import hiberspring.util.MessageName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="product")
@XmlAccessorType(XmlAccessType.FIELD)
@MessageName(name= "Product")
public class ProductSeedDto {

    @XmlAttribute(name="name")
    private String name;

    @XmlAttribute(name = "clients")
    private Integer clients;

    @XmlElement(name = "branch")
    private String branch;

    @NotBlank
    public String getName() {
        return name;
    }

    @NotNull
    @Positive
    public Integer getClients() {
        return clients;
    }

    @NotBlank
    public String getBranch() {
        return branch;
    }

    @Override
    public String toString() {
        return name;
    }
}
