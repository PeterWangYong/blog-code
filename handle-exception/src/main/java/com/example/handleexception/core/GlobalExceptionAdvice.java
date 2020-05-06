package com.example.handleexception.core;

import com.example.handleexception.core.configuration.ExceptionCodeConfiguration;
import com.example.handleexception.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionAdvice {
  @Autowired
  private ExceptionCodeConfiguration codeConfiguration;

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public UnifyResponse handleException(HttpServletRequest req, Exception e) {
    return new UnifyResponse(ExceptionCode.UNKNOWN, codeConfiguration.getMessage(ExceptionCode.UNKNOWN), this.getRequest(req));
  }

  @ExceptionHandler(HttpException.class)
  public ResponseEntity<UnifyResponse> handleHttpException(HttpServletRequest req, HttpException e) {
    int code = e.getCode();
    UnifyResponse response = new UnifyResponse(code, codeConfiguration.getMessage(code), this.getRequest(req));
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    HttpStatus httpStatus = HttpStatus.resolve(e.getHttpStatusCode());
    return new ResponseEntity<>(response, httpHeaders, httpStatus);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public UnifyResponse handleConstraintException(HttpServletRequest req, ConstraintViolationException e) {
    StringBuilder messageBuilder = new StringBuilder();
    e.getConstraintViolations().forEach(violation -> {
      String param = violation.getPropertyPath().toString().replaceAll("\\w+\\.", "");
      String message = violation.getMessage();
      messageBuilder.append(param).append(":").append(message).append(";");
    });
    return new UnifyResponse(ExceptionCode.PARAMS_ERROR, messageBuilder.toString(), this.getRequest(req));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public UnifyResponse handleMethodArgumentException(HttpServletRequest req, MethodArgumentNotValidException e) {
    StringBuilder messageBuilder = new StringBuilder();
    e.getBindingResult().getFieldErrors().forEach(fieldError -> {
      String field = fieldError.getField();
      String message = fieldError.getDefaultMessage();
      messageBuilder.append(field).append(":").append(message).append(";");
    });
    return new UnifyResponse(ExceptionCode.PARAMS_ERROR, messageBuilder.toString(), this.getRequest(req));
  }

  // 获取请求方法和路径
  private String getRequest(HttpServletRequest req) {
    String url = req.getRequestURI();
    String method = req.getMethod();
    return method + " " + url;
  }
}
