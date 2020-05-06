package com.example.handleexception.exception.http;

public class NotFoundHttpException extends HttpException {
  public NotFoundHttpException(int code) {
    this.code = code;
    this.httpStatusCode = 404;
  }
}
