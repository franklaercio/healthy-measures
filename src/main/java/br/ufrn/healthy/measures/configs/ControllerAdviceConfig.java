package br.ufrn.healthy.measures.configs;

import br.ufrn.healthy.measures.http.data.ErrorResponse;
import br.ufrn.healthy.measures.exceptions.BadRequestException;
import br.ufrn.healthy.measures.exceptions.InternalServerErrorException;
import br.ufrn.healthy.measures.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceConfig {

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<ErrorResponse> badRequestException(BadRequestException badRequestException) {
    return new ResponseEntity<>(new ErrorResponse(
        HttpStatus.BAD_REQUEST.value(), badRequestException.getMessage()), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorResponse> notFoundException(NotFoundException notFoundException) {
    return new ResponseEntity<>(new ErrorResponse(
        HttpStatus.NOT_FOUND.value(), notFoundException.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(InternalServerErrorException.class)
  public ResponseEntity<ErrorResponse> internalServerErrorException(
      InternalServerErrorException internalServerErrorException) {
    return new ResponseEntity<>(
        new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
            internalServerErrorException.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
