package br.ufrn.healthy.measures.http;

import br.ufrn.healthy.measures.http.data.response.ErrorResponse;
import br.ufrn.healthy.measures.http.exceptions.BadRequestException;
import br.ufrn.healthy.measures.http.exceptions.InternalServerErrorException;
import br.ufrn.healthy.measures.http.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;

public interface ExceptionController {

  ResponseEntity<ErrorResponse> badRequestException(BadRequestException badRequestException);

  ResponseEntity<ErrorResponse> notFoundException(NotFoundException notFoundException);

  ResponseEntity<ErrorResponse> internalServerErrorException(
      InternalServerErrorException internalServerErrorException);

}
