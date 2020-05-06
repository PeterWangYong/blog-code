package com.example.handleexception.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UnifyResponse {
  private int code;
  private String message;
  private String request;
}
