package hiberspring.service.impl;

import hiberspring.domain.dtos.ProductSeedDto;
import hiberspring.domain.dtos.ProductSeedRootDto;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Product;
import hiberspring.repository.ProductRepository;
import hiberspring.service.BranchService;
import hiberspring.service.ProductService;
import hiberspring.util.FileService;
import hiberspring.util.MessageService;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    public static final String PRODUCTS_FILE_PATH = "src/main/resources/files/products.xml";
    private final ProductRepository repository;
    private final BranchService branchService;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final ModelMapper mapper;
    private final MessageService messageService;

    public ProductServiceImpl(ProductRepository repository,
                              BranchService branchService,
                              FileService fileService,
                              ValidationUtil validator,
                              ModelMapper mapper,
                              MessageService messageService) {
        this.repository = repository;
        this.branchService = branchService;
        this.fileService = fileService;
        this.validator = validator;
        this.mapper = mapper;
        this.messageService = messageService;
    }

    @Override
    public Boolean productsAreImported() {
        return repository.count() > 0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return fileService.readString(PRODUCTS_FILE_PATH);
    }

    @Override
    public String importProducts() throws JAXBException, IOException {
        return this.fileService.readXmlFile(PRODUCTS_FILE_PATH, ProductSeedRootDto.class)
                .getProducts()
                .stream()
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String persistIfValid(ProductSeedDto product) {
        Optional<Branch> branch = branchService.getByName(product.getBranch());
        boolean isValid = this.validator.isValid(product, this::isUnique) && branch.isPresent();
        String message = this.messageService.getMessage(product, isValid);
        if (isValid) {
            Product dbProduct = this.mapper.map(product, Product.class);
            dbProduct.setBranch(branch.get());
            this.repository.save(dbProduct);
        }
        return message;
    }

    private boolean isUnique(ProductSeedDto e) {
        return !repository.existsByName(e.getName());
    }
}
