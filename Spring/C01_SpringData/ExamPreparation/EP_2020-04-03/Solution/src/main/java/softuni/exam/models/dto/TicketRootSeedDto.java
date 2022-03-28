package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tickets")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketRootSeedDto {

    @XmlElement(name = "ticket")
    private List<TicketSeedDto> tickets;

    public List<TicketSeedDto> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketSeedDto> tickets) {
        this.tickets = tickets;
    }
}
