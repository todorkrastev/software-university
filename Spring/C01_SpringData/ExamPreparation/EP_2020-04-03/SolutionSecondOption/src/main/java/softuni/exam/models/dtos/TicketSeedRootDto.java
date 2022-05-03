package softuni.exam.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="tickets")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketSeedRootDto {
    @XmlElement(name="ticket")
    private final List<TicketSeedDto> tickets;

    public TicketSeedRootDto() {
        this.tickets = new ArrayList<>();
    }

    public List<TicketSeedDto> getTickets() {
        return tickets;
    }
}
