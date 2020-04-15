package br.com.cielo.challenge.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> handleException(Exception e) {
		Error error = new Error();
		error.setDescription(e.getMessage());
		error.setTime(new Date());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}

}
