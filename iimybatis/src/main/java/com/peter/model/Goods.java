package com.peter.model;

import lombok.Data;

import java.util.List;

@Data
public class Goods {
  private long id;
  private String name;
  private List<Customer> customers;
}
