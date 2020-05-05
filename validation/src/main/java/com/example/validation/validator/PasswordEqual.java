package com.example.validation.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = PasswordEqualValidator.class)
public @interface PasswordEqual {
  int min() default 5;
  String message() default "两次密码不一致";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };
}
