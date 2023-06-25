package com.shop.demo.adapters.exception;

import com.shop.demo.adapters.api.price.dto.ErrorDTO;
import jakarta.xml.bind.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(buildError(HttpStatus.BAD_REQUEST,
                "Internal server error: " + e.getMessage()));
    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorDTO> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
      return ResponseEntity.badRequest().body(buildError(HttpStatus.BAD_REQUEST,"Missing request parameter: " + e.getMessage()));
    }
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorDTO> handleValidationException(ValidationException e) {
        return ResponseEntity.badRequest().body(buildError(HttpStatus.BAD_REQUEST,"Validation error: " + e.getMessage()));
    }

    private ErrorDTO buildError(HttpStatus status, String message){
        return ErrorDTO.builder()
            .error(status.value())
            .responseType(status.name())
            .errorMessage(message)
            .dateTime(LocalDateTime.now())
            .build();
    }

}
