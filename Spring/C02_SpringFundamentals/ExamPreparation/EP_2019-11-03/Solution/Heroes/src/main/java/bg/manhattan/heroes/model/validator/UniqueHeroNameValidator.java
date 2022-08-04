package bg.manhattan.heroes.model.validator;

import bg.manhattan.heroes.service.HeroService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueHeroNameValidator implements ConstraintValidator<UniqueHeroName, String> {
    private final HeroService heroService;

    public UniqueHeroNameValidator(HeroService heroService) {
        this.heroService = heroService;
    }

    @Override
    public void initialize(UniqueHeroName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String heroName, ConstraintValidatorContext context) {
       return this.heroService.getHeroByHeroName(heroName).isEmpty();
    }
}
