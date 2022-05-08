package com.quintrix.jfs.quintrixspring.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
  protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
    Error error = new Error();
    error.setMessage(ex.getMessage());
    error.setCustomMessage("This came from IllegalArgumentException or IllegalStateException");
    error.setHttpStatusCode(HttpStatus.CONFLICT.value());

    return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.CONFLICT, request);
  }

  @ExceptionHandler({CarNotFoundException.class})
  public final ResponseEntity<Object> handleException2(Exception ex, WebRequest request) {
    HttpHeaders headers = new HttpHeaders();

    if (ex instanceof CarNotFoundException) {
      HttpStatus status = HttpStatus.NOT_FOUND;
      CarNotFoundException cnfe = (CarNotFoundException) ex;
      Error error = new Error();

      error.setMessage(cnfe.detailedMessage);
      error.setCustomMessage(cnfe.displayMessage);
      error.setHttpStatusCode(status.value());

      return handleExceptionInternal(ex, error, headers, status, request);
    }

    return null;
  }

}
