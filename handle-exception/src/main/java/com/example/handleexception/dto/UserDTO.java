package com.example.handleexception.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;

@Getter
@Setter
public class UserDTO {
  @Max(20)
  private Integer id;
  private String name;
}
