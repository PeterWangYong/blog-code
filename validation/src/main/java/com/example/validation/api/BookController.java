package com.example.validation.api;

import com.example.validation.common.InvokeValidator;
import com.example.validation.dto.BookDTO;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

@RestController
@Validated
public class BookController {

  @Autowired
  private InvokeValidator invokeValidator;

  @GetMapping("/book/{id}")
  public String getById(@PathVariable @Max(50) Integer id) {
    return "bookById";
  }

  @GetMapping("/bookByName")
  public String getByName(@RequestParam @Length(min = 2, max = 20) String name) {
    return "bookByName";
  }

  @PostMapping("/book/add")
  public BookDTO addBook(@RequestBody @Validated BookDTO bookDTO) {
    return bookDTO;
  }

  @GetMapping("/invokeValidator")
  public String invokeValidator() {
    return invokeValidator.validate();
  }

}
