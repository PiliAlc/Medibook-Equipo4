package com.medibook.exceptions;

/*import org.apache.log4j.Logger;*/
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;




public class GlobalExceptions {

private final static Logger logger = Logger.getLogger(GlobalExceptions.class);

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> procesarErrorBadRequest(ResourceNotFoundException ex) {

        logger.error(ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> allErros(Exception ex, WebRequest req) {

        logger.error(ex.getMessage());

        return new ResponseEntity("Error " + ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

