package bg.softuni.productshop.configurations;

import bg.softuni.productshop.models.dtos.CategoryViewWithProductsCountAvgPriceAndTotalRevenue;
import bg.softuni.productshop.models.entities.Category;
import bg.softuni.productshop.models.entities.Product;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        categoryViewWithProductsCountAvgPriceAndTotalRevenue(modelMapper);

        return modelMapper;
    }

    private void categoryViewWithProductsCountAvgPriceAndTotalRevenue(ModelMapper mapper) {
        Converter<List<Product>, BigDecimal> toAvgPrice =
                ctx -> ctx.getSource() == null ? BigDecimal.ZERO : average(ctx.getSource(), RoundingMode.HALF_UP);

        Converter<List<Product>, BigDecimal> toRevenue =
                ctx -> ctx.getSource() == null ? BigDecimal.ZERO : sum(ctx.getSource());

        Converter<List<Product>, Long> toCount =
                ctx -> ctx.getSource() == null ? 0L : count(ctx.getSource());


        mapper.createTypeMap(Category.class, CategoryViewWithProductsCountAvgPriceAndTotalRevenue.class)
                .addMappings(mpr -> {
                    mpr.using(toCount).map(Category::getProducts, CategoryViewWithProductsCountAvgPriceAndTotalRevenue::setProductsCount);
                    mpr.using(toAvgPrice).map(Category::getProducts, CategoryViewWithProductsCountAvgPriceAndTotalRevenue::setAveragePrice);
                    mpr.using(toRevenue).map(Category::getProducts, CategoryViewWithProductsCountAvgPriceAndTotalRevenue::setTotalRevenue);
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

}