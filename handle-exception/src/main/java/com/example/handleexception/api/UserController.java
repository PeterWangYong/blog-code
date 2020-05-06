package com.example.handleexception.api;

import com.example.handleexception.core.ExceptionCode;
import com.example.handleexception.dto.UserDTO;
import com.example.handleexception.exception.http.NotFoundHttpException;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

@RestController
@Validated
public class UserController {
  @GetMapping("/user/{id}")
  public String getUser(@PathVariable @Max(20) Integer id, @RequestParam @Length(min = 2, max = 10) String name) {
    throw new NotFoundHttpException(ExceptionCode.RESOURCE_NOT_FOUND);
//    return "user";
  }

  @PostMapping("/user/add")
  public UserDTO addUser(@RequestBody @Validated UserDTO userDTO) {
    return userDTO;
  }

}
