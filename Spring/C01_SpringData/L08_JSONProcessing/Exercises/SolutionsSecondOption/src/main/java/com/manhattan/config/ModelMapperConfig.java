package com.manhattan.config;

import com.manhattan.models.carDealer.dtos.CustomerJsonReadDto;
import com.manhattan.models.carDealer.dtos.LocalSupplierDto;
import com.manhattan.models.carDealer.dtos.OrderedCustomersDto;
import com.manhattan.models.carDealer.entities.Customer;
import com.manhattan.models.carDealer.entities.Part;
import com.manhattan.models.carDealer.entities.Supplier;
import com.manhattan.models.productsShop.dtos.CategoriesByProductsDto;
import com.manhattan.models.productsShop.dtos.ProductsInRangeDto;
import com.manhattan.models.productsShop.dtos.UserAndSoldProductsDto;
import com.manhattan.models.productsShop.entities.Category;
import com.manhattan.models.productsShop.entities.Product;
import com.manhattan.models.productsShop.entities.User;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        productProductsInRangeDto(mapper);

        categoryToCategoriesByProductsDto(mapper);

        userToUserAndSoldProductsDto(mapper);

        customerJsonReadDtoToCustomer(mapper);

        customerToOrderedCustomersDto(mapper);

        supplierLocalSuppliersDto(mapper);

        return mapper;
    }

    private void supplierLocalSuppliersDto(ModelMapper mapper) {
        Converter<Set<Part>, Integer> partsCount = ctx -> ctx.getSource() == null ? 0 : ctx.getSource().size();
        mapper.createTypeMap(Supplier.class, LocalSupplierDto.class)
                .addMappings(mpr->mpr.using(partsCount).map(Supplier::getParts, LocalSupplierDto::setPartsCount));
    }

    private void productProductsInRangeDto(ModelMapper mapper) {
        Converter<BigDecimal, String> priceToString =
                ctx -> ctx.getSource() == null ? "0" : String.format("%.2f", ctx.getSource());

        Converter<User, String> toFullName =
                ctx -> ctx.getSource() == null ? "" : getFullName(ctx);

        mapper.createTypeMap(Product.class, ProductsInRangeDto.class)
                .addMappings(mpr -> {
                    mpr.using(priceToString).map(Product::getPrice, ProductsInRangeDto::setPrice);
                    mpr.using(toFullName).map(Product::getSeller, ProductsInRangeDto::setSeller);
                });
    }

    private String getFullName(MappingContext<User, String> ctx) {
        if (ctx.getSource().getFirstName() == null) {
            return ctx.getSource().getLastName();
        }

        return String.format("%s %s", ctx.getSource().getFirstName(), ctx.getSource().getLastName());
    }

    private void categoryToCategoriesByProductsDto(ModelMapper mapper) {
        Converter<List<Product>, BigDecimal> toAvgPrice =
                ctx -> ctx.getSource() == null ? BigDecimal.ZERO : average(ctx.getSource(), RoundingMode.HALF_UP);

        Converter<List<Product>, BigDecimal> toRevenue =
                ctx -> ctx.getSource() == null ? BigDecimal.ZERO : sum(ctx.getSource());

        Converter<List<Product>, Long> toCount =
                ctx -> ctx.getSource() == null ? 0L : count(ctx.getSource());


        mapper.createTypeMap(Category.class, CategoriesByProductsDto.class)
                .addMappings(mpr -> {
                    mpr.using(toCount).map(Category::getProducts, CategoriesByProductsDto::setProductCount);
                    mpr.using(toAvgPrice).map(Category::getProducts, CategoriesByProductsDto::setAveragePrice);
                    mpr.using(toRevenue).map(Category::getProducts, CategoriesByProductsDto::setTotalRevenue);
                });
    }

    private BigDecimal average(Collection<Product> products, RoundingMode roundingMode) {
        BigDecimal sum = sum(products);
        long count = count(products);
        return sum.divide(new BigDecimal(count), roundingMode);
    }

    private long count(Collection<Product> products) {
        long count = products.stream().filter(Objects::nonNull).count();
        return count;
    }

    private BigDecimal sum(Collection<Product> products) {
        BigDecimal sum = products.stream()
                .map(Product::getPrice)
                .map(Objects::requireNonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum;
    }

    private void userToUserAndSoldProductsDto(ModelMapper mapper) {
        Converter<Set<Product>, Integer> toProductCount =
                ctx -> Math.toIntExact(ctx.getSource() == null ? 0L :
                        ctx.getSource().size());

        mapper.createTypeMap(User.class, UserAndSoldProductsDto.class)
                .addMappings(mpr -> mpr.using(toProductCount).<Integer>map(src -> src.getSoldProducts(),
                        (dest, v) -> dest.getSoldProducts().setCount(v)));
    }

    private void customerJsonReadDtoToCustomer(ModelMapper mapper) {
        Converter<String, LocalDate> toDate =
                ctx -> LocalDate.parse(ctx.getSource().split("T")[0]);

        mapper.createTypeMap(CustomerJsonReadDto.class, Customer.class)
                .addMappings(mpr -> mpr.using(toDate).map(CustomerJsonReadDto::getBirthDate, Customer::setBirthDate));
    }

    private void customerToOrderedCustomersDto(ModelMapper mapper) {
        Converter<LocalDate, String> toDateToString =
                ctx -> DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(ctx.getSource());

        mapper.createTypeMap(Customer.class, OrderedCustomersDto.class)
                .addMapping(Customer::getBirthDate, OrderedCustomersDto::setBirthDate);
    }
}
