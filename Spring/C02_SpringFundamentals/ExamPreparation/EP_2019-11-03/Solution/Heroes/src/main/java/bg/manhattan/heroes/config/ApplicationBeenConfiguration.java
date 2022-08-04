package bg.manhattan.heroes.config;

import bg.manhattan.heroes.model.entity.Hero;
import bg.manhattan.heroes.model.entity.User;
import bg.manhattan.heroes.model.entity.enums.HeroClass;
import bg.manhattan.heroes.model.service.HeroServiceModel;
import bg.manhattan.heroes.model.service.UserServiceModel;
import bg.manhattan.heroes.model.view.HeroViewModel;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.util.Locale;

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

        Converter<HeroClass, String> toPicture = ctx -> ctx.getSource() == null ? null :
                String.format("/img/%s.jpg", ctx.getSource().toString().toLowerCase());

        mapper.createTypeMap(HeroServiceModel.class, HeroViewModel.class)
                .addMappings(mpr -> mpr.using(toPicture).map(HeroServiceModel::getHeroClass, HeroViewModel::setImageUri));


        return mapper;
    }
}
