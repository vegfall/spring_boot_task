package no.falldal.springboottask.parts;

import no.falldal.springboottask.parts.exceptions.PartsRepositoryExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PartsControllerAdvice {
    private final Logger logger = LoggerFactory.getLogger(PartsControllerAdvice.class);

    @ExceptionHandler(value = PartsRepositoryExceptions.class)
    public ResponseEntity<String> handleAddPartsException(PartsRepositoryExceptions error) {
        logger.error("PartsException because fish... " + error.getMessage());
        return ResponseEntity.badRequest().body("Sorry, fish are not parts");
    }
}
