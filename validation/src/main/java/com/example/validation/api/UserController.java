package com.example.validation.api;

import com.example.validation.dto.UserDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class UserController {
  @PostMapping("/login")
  public String login(@RequestBody @Validated UserDTO userDTO) {
    return "login success";
  }
}
