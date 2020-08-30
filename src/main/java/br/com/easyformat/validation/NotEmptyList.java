package br.com.easyformat.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import br.com.easyformat.validation.constraint.NotEmptyListValitator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = NotEmptyListValitator.class)
public @interface NotEmptyList {
    
    String message() default "A lista não pode ser vazia";
    Class<?> [] groups() default{};
    Class<? extends Payload> [] payload() default {};
}