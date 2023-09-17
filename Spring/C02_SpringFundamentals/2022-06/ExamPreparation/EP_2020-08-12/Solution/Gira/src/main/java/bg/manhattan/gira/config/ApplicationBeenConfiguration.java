package bg.manhattan.gira.config;


import bg.manhattan.gira.model.entity.User;
import bg.manhattan.gira.model.service.UserServiceModel;
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
    public ModelMapper modelMapper(PasswordEncoder passwordEncoder){
        ModelMapper mapper = new ModelMapper();

        Converter<String, String> passwordHash = ctx -> ctx.getSource() == null ? null :
                passwordEncoder.encode(ctx.getSource());

        //encode password on the fly
        mapper.createTypeMap(UserServiceModel.class, User.class)
                .addMappings(mpr -> mpr.using(passwordHash)
                        .map(UserServiceModel::getPassword, User::setPasswordHash));

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
