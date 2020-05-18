package com.peter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
  private Long id;
  private String username;
  private String password;
  private int age;
  private List<Long> ids;
}
