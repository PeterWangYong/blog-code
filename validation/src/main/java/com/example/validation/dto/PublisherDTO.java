package com.example.validation.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class PublisherDTO {
  @Length(min = 2, max = 20)
  private String name;
}
