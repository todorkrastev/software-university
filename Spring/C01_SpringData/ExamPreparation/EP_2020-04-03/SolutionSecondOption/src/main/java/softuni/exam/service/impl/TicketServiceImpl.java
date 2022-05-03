package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.PassengerSeedDto;
import softuni.exam.models.dtos.TicketSeedDto;
import softuni.exam.models.dtos.TicketSeedRootDto;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Plane;
import softuni.exam.models.entities.Ticket;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.TicketRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.PlaneService;
import softuni.exam.service.TicketService;
import softuni.exam.service.TownService;
import softuni.exam.util.FileService;
import softuni.exam.util.MessageService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {
    public static final String TICKETS_FILE_PATH = "src/main/resources/files/xml/tickets.xml";
    private final TicketRepository repository;
    private final FileService fileService;
    private final TownService townService;
    private final PassengerService passengerService;
    private final PlaneService planeService;
    private final ValidationUtil validator;
    private final ModelMapper mapper;
    private final MessageService messageService;

    public TicketServiceImpl(TicketRepository repository,
                             FileService fileService,
                             TownService townService,
                             PassengerService passengerService,
                             PlaneService planeService,
                             ValidationUtil validator,
                             ModelMapper mapper,
                             MessageService messageService) {
        this.repository = repository;
        this.fileService = fileService;
        this.townService = townService;
        this.passengerService = passengerService;
        this.planeService = planeService;
        this.validator = validator;
        this.mapper = mapper;
        this.messageService = messageService;
    }


    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return fileService.readString(TICKETS_FILE_PATH);
    }

    @Override
    public String importTickets() throws JAXBException, IOException {
        return this.fileService.readXmlFile(TICKETS_FILE_PATH, TicketSeedRootDto.class)
                .getTickets()
                .stream()
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String persistIfValid(TicketSeedDto ticket) {
        Optional<Town> fromTown = townService.getByName(ticket.getFromTown().getName());
        Optional<Town> toTown = townService.getByName(ticket.getFromTown().getName());
        Optional<Passenger> passenger = passengerService.getByEmail(ticket.getPassenger().getEmail());
        Optional<Plane> plane = planeService.getByRegisterNumber(ticket.getPlane().getRegisterNumber());
        boolean isValid =
                this.validator.isValid(ticket, this::isUnique)
                        && fromTown.isPresent() && toTown.isPresent()
                        && passenger.isPresent() && plane.isPresent();
        String message = this.messageService.getMessage(ticket, isValid);

        if (isValid){
            Ticket dbTicket = this.mapper.map(ticket, Ticket.class);
            dbTicket.setFromTown(fromTown.get());
            dbTicket.setToTown(toTown.get());
            dbTicket.setPassenger(passenger.get());
            dbTicket.setPlane(plane.get());
            this.repository.save(dbTicket);
        }

        return message;
    }

    private boolean isUnique(TicketSeedDto ticket) {
        return !repository.existsBySerialNumber(ticket.getSerialNumber());
    }
}
