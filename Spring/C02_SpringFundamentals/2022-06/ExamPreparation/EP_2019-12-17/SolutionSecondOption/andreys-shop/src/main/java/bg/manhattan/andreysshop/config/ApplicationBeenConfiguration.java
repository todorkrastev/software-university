package bg.manhattan.andreysshop.config;

import bg.manhattan.andreysshop.model.entity.Product;
import bg.manhattan.andreysshop.model.entity.User;
import bg.manhattan.andreysshop.model.service.UserServiceModel;
import bg.manhattan.andreysshop.model.view.ProductDetailsViewModel;
import bg.manhattan.andreysshop.model.view.ProductViewModel;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
public class ApplicationBeenConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper(PasswordEncoder passwordEncoder) {
        ModelMapper mapper = new ModelMapper();

        Converter<String, String> passwordHash = ctx -> ctx.getSource() == null ? null :
                passwordEncoder.encode(ctx.getSource());

        //encode password on the fly
        mapper.createTypeMap(UserServiceModel.class, User.class)
                .addMappings(mpr -> mpr.using(passwordHash)
                        .map(UserServiceModel::getPassword, User::setPasswordHash));


        Converter<Product, String> toPicture = ctx -> ctx.getSource() == null ? null :
                String.format("/img/%s-%s.jpg"
                        , ctx.getSource().getSex().toString().toUpperCase()
                        , ctx.getSource().getCategory().toString().toUpperCase());

        mapper.createTypeMap(Product.class, ProductViewModel.class)
         .addMappings(mpr -> mpr.using(toPicture)
                 .map((src)-> src, ProductViewModel::setPicture));
        mapper.createTypeMap(Product.class, ProductDetailsViewModel.class)
         .addMappings(mpr -> mpr.using(toPicture)
                 .map((src)-> src, ProductDetailsViewModel::setPicture));

//        Converter<Category, String> categoryToPath = ctx -> ctx.getSource() == null ? null :
//                String.format("/images/%s.png"
//                        ,ctx.getSource().getName().name().toLowerCase(Locale.ROOT));

//        Converter<Category, Integer> toTime = ctx -> ctx.getSource() == null ? null :
//                ctx.getSource().getName().getCategoryTime();


//        mapper.createTypeMap(Order.class, OrderViewModel.class)
//                .addMappings(mpr -> mpr.using(categoryToPath)
//                        .map(Order::getCategory, OrderViewModel::setCategory))
//                .addMappings(mpr-> mpr.using(toTime)
//                        .map(Order::getCategory, OrderViewModel::setPrepareTime));

        return mapper;
    }
}
