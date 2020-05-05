package com.example.validation.common;

import com.example.validation.dto.PublisherDTO;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Component
public class InvokeValidator {

  private Validator validator;

  public InvokeValidator(Validator validator) {
    this.validator = validator;
  }

  public String validate() {
    PublisherDTO publisher = new PublisherDTO();
    publisher.setName("a");
    Set<ConstraintViolation<PublisherDTO>> violations = this.validator.validate(publisher);
    // 长度需要在2和20之间
    StringBuilder message = new StringBuilder();
    violations.forEach(violation -> message.append(violation.getMessage()).append(";"));
    return message.toString();
  }

  public static void main(String[] args) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    PublisherDTO publisher = new PublisherDTO();
    publisher.setName("a");
    Set<ConstraintViolation<PublisherDTO>> violations = validator.validate(publisher);
    // 长度需要在2和20之间
    violations.forEach(violation -> System.out.println(violation.getMessage()));
  }
}
