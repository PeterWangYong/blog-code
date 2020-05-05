package com.example.validation.model;

import org.hibernate.validator.constraints.Length;

//import javax.persistence.Entity;
//import javax.persistence.Id;
import javax.validation.constraints.Max;

//@Entity
public class Book {
//  @Id
  @Max(20)
  private Integer id;
  @Length(min = 2, max = 20)
  private String name;
}
