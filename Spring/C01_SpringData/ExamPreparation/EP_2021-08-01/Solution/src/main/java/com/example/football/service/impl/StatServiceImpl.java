package com.example.football.service.impl;

import com.example.football.constant.GlobalConstant;
import com.example.football.models.dto.StatRootSeedDto;
import com.example.football.models.dto.StatWithPassingShootingEndurance;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class StatServiceImpl implements StatService {
    private final StatRepository statRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public StatServiceImpl(StatRepository statRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.statRepository = statRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(GlobalConstant.STATS_FILE_PATH));
    }

    @Override
    public String importStats() throws JAXBException, FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();


        StatRootSeedDto statRootSeedDto = this.xmlParser.fromFile(GlobalConstant.STATS_FILE_PATH, StatRootSeedDto.class);

        statRootSeedDto
                .getStats()
                .stream()
                .filter(statWithPassingShootingEndurance -> {
                    boolean isValid = this.validationUtil.isValid(statWithPassingShootingEndurance) &&
                            !doesStatExist(statWithPassingShootingEndurance);

                    stringBuilder
                            .append(isValid ?
                                    String.format("Successfully imported Stat %.2f - %.2f - %.2f",
                                            statWithPassingShootingEndurance.getShooting(),
                                            statWithPassingShootingEndurance.getPassing(),
                                            statWithPassingShootingEndurance.getEndurance()) :
                                    "Invalid Stat")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(statWithPassingShootingEndurance -> this.modelMapper.map(statWithPassingShootingEndurance, Stat.class))
                .forEach(this.statRepository::save);

        return stringBuilder.toString();
    }

    @Override
    public boolean doesEntityIdExist(Long id) {
        return this.statRepository.existsById(id);
    }

    @Override
    public Stat findById(Long id) {
        return this.statRepository.findById(id).orElse(null);
    }

    private boolean doesStatExist(StatWithPassingShootingEndurance stat) {
        return this.statRepository.existsByPassingAndShootingAndEndurance(stat.getPassing(), stat.getShooting(), stat.getEndurance());
    }

}
