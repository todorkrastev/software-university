package com.spotifyplaylist.vallidation;

import com.spotifyplaylist.service.impl.AuthServiceImpl;
import com.spotifyplaylist.vallidation.annotation.UniqueUsername;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final AuthServiceImpl userService;

    public UniqueUsernameValidator(AuthServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.userService.findUserByUsername(value) == null;
    }
}