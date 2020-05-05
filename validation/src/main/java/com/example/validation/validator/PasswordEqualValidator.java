package com.example.validation.validator;

import com.example.validation.dto.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordEqualValidator implements ConstraintValidator<PasswordEqual, UserDTO> {

  private int min;

  @Override
  public void initialize(PasswordEqual constraintAnnotation) {
    this.min = constraintAnnotation.min();
  }

  @Override
  public boolean isValid(UserDTO userDTO, ConstraintValidatorContext constraintValidatorContext) {
    String password1 = userDTO.getPassword1();
    String password2 = userDTO.getPassword2();
    return password1 != null && password1.length() >= this.min && password1.equals(password2);
  }
}
