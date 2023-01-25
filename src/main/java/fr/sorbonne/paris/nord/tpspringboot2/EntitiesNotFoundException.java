package fr.sorbonne.paris.nord.tpspringboot2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntitiesNotFoundException extends RuntimeException {
    public EntitiesNotFoundException(String message) {
        super(message);
    }

    public EntitiesNotFoundException() {

    }
}
