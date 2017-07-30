package com.neu.edu.controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.neu.edu.pojo.User;

import org.springframework.validation.ValidationUtils;

public class UserValidator implements Validator {

    public boolean supports(@SuppressWarnings("rawtypes") Class aClass)
    {
        return aClass.equals(User.class);
    }

    @SuppressWarnings("unused")
	public void validate(Object obj, Errors errors)
    {
    	User user = (User) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
    }
}
