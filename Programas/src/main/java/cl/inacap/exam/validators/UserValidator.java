package cl.inacap.exam.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cl.inacap.exam.models.User;



@Component
public class UserValidator implements Validator {
    
    // 1
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (!user.getPasswdConf().equals(user.getPasswd())) {
            // 3
            errors.rejectValue("passwdConf", "Match");
        }     
        
        if (user.getEmail().length() < 6) {
        	errors.rejectValue("email", "Length");
        }
        
    }
}
