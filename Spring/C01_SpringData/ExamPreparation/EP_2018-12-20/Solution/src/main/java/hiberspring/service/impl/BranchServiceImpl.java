package hiberspring.service.impl;

import hiberspring.domain.dtos.BranchSeedDto;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Town;
import hiberspring.repository.BranchRepository;
import hiberspring.service.BranchService;
import hiberspring.service.TownService;
import hiberspring.util.FileService;
import hiberspring.util.MessageService;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {
    public static final String BRANCHES_FILE_PATH = "src/main/resources/files/branches.json";
    private final BranchRepository repository;
    private final TownService townService;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final ModelMapper mapper;
    private final MessageService messageService;

    public BranchServiceImpl(BranchRepository repository,
                             TownService townService,
                             FileService fileService,
                             ValidationUtil validator,
                             ModelMapper mapper,
                             MessageService messageService) {
        this.repository = repository;
        this.townService = townService;
        this.fileService = fileService;
        this.validator = validator;
        this.mapper = mapper;
        this.messageService = messageService;
    }

    @Override
    public Boolean branchesAreImported() {
        return repository.count() > 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return fileService.readString(BRANCHES_FILE_PATH);
    }

    @Override
    public String importBranches(String branchesFileContent) throws IOException {
        return Arrays.stream(this.fileService.readJsonFile(BRANCHES_FILE_PATH, BranchSeedDto[].class))
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public Optional<Branch> getByName(String name) {
        return repository.findOneByName(name);
    }

    private String persistIfValid(BranchSeedDto branch) {
        Optional<Town> town = townService.getTownByName(branch.getTown());
        boolean isValid = this.validator.isValid(branch, this::isUnique) && town.isPresent();
        String message = this.messageService.getMessage(branch, isValid);

        if (isValid) {
            Branch dbBranch = mapper.map(branch, Branch.class);
            dbBranch.setTown(town.get());
            this.repository.save(dbBranch);
        }

        return message;
    }

    private boolean isUnique(BranchSeedDto e) {
        return !repository.existsByName(e.getName());
    }
}
