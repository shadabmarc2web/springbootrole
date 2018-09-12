package com.marc2web.demo.validator;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.marc2web.demo.dao.UserInfoDao;
import com.marc2web.demo.model.UserInfo;

@Component
public class UserValidator implements Validator {
    
	@Autowired
    private UserInfoDao userInfoDao;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserInfo.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserInfo user = (UserInfo) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 4 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        
       if (userInfoDao.getActiveUser(user.getUsername()) != null) {       	
           	
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 4 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (user.getEmail().length() < 4 || user.getEmail().length() > 32) {
            errors.rejectValue("email", "valid.userForm.email");
        }
    }
}
