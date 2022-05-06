package hiberspring.service;

import hiberspring.domain.entities.Branch;

import java.io.IOException;
import java.util.Optional;

public interface BranchService {

    Boolean branchesAreImported();

    String readBranchesJsonFile() throws IOException;

    String importBranches(String branchesFileContent) throws IOException;

    Optional<Branch> getByName(String branch);
}
