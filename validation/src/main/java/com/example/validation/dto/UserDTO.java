package com.example.validation.dto;

import com.example.validation.validator.PasswordEqual;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@PasswordEqual(min = 10)
public class UserDTO {
  private String name;
  private String password1;
  private String password2;
}
