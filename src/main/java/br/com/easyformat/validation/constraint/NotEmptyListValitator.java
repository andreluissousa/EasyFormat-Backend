package br.com.easyformat.validation.constraint;

import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import br.com.easyformat.validation.NotEmptyList;

public class NotEmptyListValitator implements ConstraintValidator<NotEmptyList, List<?>> {


    @Override
    public boolean isValid(List<?> value, ConstraintValidatorContext context) {
        return value != null && !value.isEmpty();
    }

    @Override
    public void initialize(NotEmptyList constraintAnnotation){
        constraintAnnotation.message();
    }
    
}