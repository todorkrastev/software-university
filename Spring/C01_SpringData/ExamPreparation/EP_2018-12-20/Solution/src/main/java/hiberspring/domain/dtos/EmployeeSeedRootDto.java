package hiberspring.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeSeedRootDto {
    @XmlElement(name="employee")
    private final List<EmployeeSeedDto> employees;

    public EmployeeSeedRootDto() {
        this.employees = new ArrayList<>();
    }

    public List<EmployeeSeedDto> getEmployees() {
        return employees;
    }
}
