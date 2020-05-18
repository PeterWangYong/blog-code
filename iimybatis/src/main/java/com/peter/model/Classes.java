package com.peter.model;

import lombok.Data;

import java.util.List;

@Data
public class Classes {
  private Long id;
  private String name;
  private List<Student> students;
}
