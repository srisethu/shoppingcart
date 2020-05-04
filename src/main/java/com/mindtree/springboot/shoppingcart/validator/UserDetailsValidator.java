package com.mindtree.springboot.shoppingcart.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.*;

import com.mindtree.springboot.shoppingcart.model.User;

/**
 * The Class UserDetailsValidator.
 *
 * @author Sridevi Uppala
 */
@Component
public class UserDetailsValidator implements Validator {

    /**
     * supports
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(User.class);
    }

    /**
     * validate user.
     *
     * @param target the object to validate
     * @param errors the errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (!user.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
            errors.rejectValue("password", "",
                    "Minimum eight characters, at least one letter and one number is mandatory");
        }
        if (!user.getName().matches("^[A-Za-z0-9]{8,}$")) {
            errors.rejectValue("name", "", "Minimum eight characters are required and can only be alphanumeric");
        }
    }

}
