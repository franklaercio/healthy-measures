package br.ufrn.healthy.measures.http.impl;

import br.ufrn.healthy.measures.http.ExceptionController;
import br.ufrn.healthy.measures.http.data.response.ErrorResponse;
import br.ufrn.healthy.measures.exceptions.BadRequestException;
import br.ufrn.healthy.measures.exceptions.InternalServerErrorException;
import br.ufrn.healthy.measures.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionControllerImpl implements ExceptionController {

  @Override
  public ResponseEntity<ErrorResponse> badRequestException(
      BadRequestException badRequestException) {
    return new ResponseEntity<>(new ErrorResponse(
        HttpStatus.BAD_REQUEST.value(), badRequestException.getMessage()), HttpStatus.BAD_REQUEST);
  }

  @Override
  public ResponseEntity<ErrorResponse> notFoundException(NotFoundException notFoundException) {
    return new ResponseEntity<>(new ErrorResponse(
        HttpStatus.NOT_FOUND.value(), notFoundException.getMessage()), HttpStatus.NOT_FOUND);
  }

  @Override
  public ResponseEntity<ErrorResponse> internalServerErrorException(
      InternalServerErrorException internalServerErrorException) {
    return new ResponseEntity<>(
        new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
            internalServerErrorException.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
