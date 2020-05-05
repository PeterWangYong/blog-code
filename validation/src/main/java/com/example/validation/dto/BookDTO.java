package com.example.validation.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Max;

@Getter
@Setter
public class BookDTO {
  @Max(50)
  private Integer id;
  @Length(min = 2, max = 20)
  private String name;
  @Valid
  private PublisherDTO publisher;
}
