package com.shop.demo.adapters.exception;

import com.shop.demo.adapters.api.price.dto.ErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleException(HttpServletRequest request, Exception e) {
        return ResponseEntity.internalServerError().body(buildError(request, HttpStatus.INTERNAL_SERVER_ERROR,
                "Internal server error: " + e.getMessage()));
    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorDto> handleMissingServletRequestParameterException(HttpServletRequest request,
                                                                                  MissingServletRequestParameterException e) {
      return ResponseEntity.badRequest().body(buildError(request, HttpStatus.BAD_REQUEST,"Missing request parameter: " + e.getMessage()));
    }
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorDto> handleValidationException(HttpServletRequest request, ValidationException e) {
        return ResponseEntity.badRequest().body(buildError(request, HttpStatus.BAD_REQUEST,"Validation error: " + e.getMessage()));
    }

    private ErrorDto buildError(HttpServletRequest request, HttpStatus status, String message){
        return ErrorDto.builder()
            .url(request.getRequestURI())
            .error(status.value())
            .responseType(status.name())
            .errorMessage(message)
            .dateTime(LocalDateTime.now())
            .build();
    }

}
