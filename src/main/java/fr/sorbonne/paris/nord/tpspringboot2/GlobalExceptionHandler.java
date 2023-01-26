package fr.sorbonne.paris.nord.tpspringboot2;

import fr.sorbonne.paris.nord.tpspringboot2.EntitiesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntitiesNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntitiesNotFoundException(EntitiesNotFoundException ex) {
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityInvalidException.class)
    public ResponseEntity<ErrorResponse> handleEntitiesNotFoundException(EntityInvalidException ex) {
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage("erreur 404haha");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}

