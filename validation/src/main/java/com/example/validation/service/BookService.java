package com.example.validation.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;

@Service
@Validated
public class BookService {
  public String getById(@Max(20) Integer id) {
    return "book";
  }
}
