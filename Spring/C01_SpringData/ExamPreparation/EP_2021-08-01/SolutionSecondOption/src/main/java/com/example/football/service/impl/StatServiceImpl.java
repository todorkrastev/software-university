package com.example.football.service.impl;

import com.example.football.models.dto.StatSeedDto;
import com.example.football.models.dto.StatSeedRootDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.FileService;
import com.example.football.service.MessageService;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StatServiceImpl implements StatService {
    public static final String STATS_FILE_PATH = "src/main/resources/files/xml/stats.xml";
    private final StatRepository repository;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final ModelMapper mapper;
    private final MessageService messageService;

    public StatServiceImpl(StatRepository repository,
                           FileService fileService,
                           ValidationUtil validator,
                           ModelMapper mapper,
                           MessageService messageService) {
        this.repository = repository;
        this.fileService = fileService;
        this.validator = validator;
        this.mapper = mapper;
        this.messageService = messageService;
    }

    @Override
    public boolean areImported() {
        return this.repository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return this.fileService.readString(STATS_FILE_PATH);
    }

    @Override
    @Transactional
    public String importStats() throws JAXBException, IOException {
        StringBuilder response = new StringBuilder();
        this.repository.saveAll(
                this.fileService.readXmlFile(STATS_FILE_PATH, StatSeedRootDto.class)
                        .getStats()
                        .stream()
                        .peek(statSeedDto -> {
                            if (exists(statSeedDto)) {
                                response.append("Invalid Stat");
                            }
                        })
                        .filter(statSeedDto -> !this.exists(statSeedDto))
                        .peek(statDto -> messageService
                                .addMessage(response, statDto, String.format("%.2f - %.2f - %.2f", statDto.getPassing(),
                                        statDto.getShooting(), statDto.getEndurance())))
                        .filter(this.validator::isValid)
                        .map(statDto -> this.mapper.map(statDto, Stat.class))
                        .collect(Collectors.toList()));
        return response.toString().trim();
    }

    @Override
    public Optional<Stat> getStatById(long id) {
        return this.repository.findById(id);
    }

    private boolean exists(StatSeedDto statDto) {
        return this.repository
                .existsByPassingAndShootingAndAndEndurance(statDto.getPassing(), statDto.getShooting(), statDto.getEndurance());
    }
}
