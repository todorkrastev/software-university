package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constant.GlobalConstant;
import softuni.exam.models.dto.TicketRootSeedDto;
import softuni.exam.models.entity.Passenger;
import softuni.exam.models.entity.Plane;
import softuni.exam.models.entity.Ticket;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TicketRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.PlaneService;
import softuni.exam.service.TicketService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final TownService townService;
    private final PassengerService passengerService;
    private final PlaneService planeService;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public TicketServiceImpl(TicketRepository ticketRepository, TownService townService, PassengerService passengerService, PlaneService planeService, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.ticketRepository = ticketRepository;
        this.townService = townService;
        this.passengerService = passengerService;
        this.planeService = planeService;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files.readString(Path.of(GlobalConstant.TICKETS_FILE_PATH));
    }

    @Override
    public String importTickets() throws JAXBException, FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();

        TicketRootSeedDto dtos = this.xmlParser.fromFile(GlobalConstant.TICKETS_FILE_PATH, TicketRootSeedDto.class);

        dtos
                .getTickets()
                .stream()
                .filter(ticketSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(ticketSeedDto) &&
                            !doesEntityExist(ticketSeedDto.getSerialNumber()) &&
                            this.townService.doesEntityExist(ticketSeedDto.getFromTown().getName()) &&
                            this.townService.doesEntityExist(ticketSeedDto.getToTown().getName()) &&
                            this.passengerService.doesEntityExist(ticketSeedDto.getPassenger().getEmail()) &&
                            this.planeService.doesEntityExist(ticketSeedDto.getPlane().getRegisterNumber());

                    stringBuilder
                            .append(isValid ?
                                    String.format("Successfully improted Ticket %s - %s",
                                            ticketSeedDto.getFromTown().getName(),
                                            ticketSeedDto.getToTown().getName()) :
                                    "Invalid Ticket")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(ticketSeedDto -> {
                    Ticket ticket = this.modelMapper.map(ticketSeedDto, Ticket.class);

                    String passengerEmail = ticketSeedDto.getPassenger().getEmail();
                    Passenger passenger = this.passengerService.findByEmail(passengerEmail);
                    ticket.setPassenger(passenger);

                    String planeRegisterNumber = ticketSeedDto.getPlane().getRegisterNumber();
                    Plane plane = this.planeService.findByRegisterNumber(planeRegisterNumber);
                    ticket.setPlane(plane);

                    String fromTown = ticketSeedDto.getFromTown().getName();
                    Town townTo = this.townService.findByName(fromTown);
                    ticket.setFromTown(townTo);

                    String toTown = ticket.getToTown().getName();
                    Town townFrom = this.townService.findByName(toTown);
                    ticket.setToTown(townFrom);

                    return ticket;
                })
                .forEach(this.ticketRepository::save);

        return stringBuilder.toString();
    }

    private boolean doesEntityExist(String serialNumber) {
        return this.ticketRepository.existsBySerialNumber(serialNumber);
    }
}
