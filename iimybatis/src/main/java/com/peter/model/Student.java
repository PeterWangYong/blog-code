package com.peter.model;

import lombok.Data;

@Data
public class Student {
  private Long id;
  private String name;
  private Classes classes;
}
