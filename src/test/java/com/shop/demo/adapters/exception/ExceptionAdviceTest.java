package com.shop.demo.adapters.exception;

import com.shop.demo.adapters.api.price.dto.ErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class ExceptionAdviceTest {
    @InjectMocks
    private ExceptionAdvice sut;
    @Test
    void whenExceptionIsTrowed_thenHandleException(){

        HttpServletRequest mockRequest = mock(HttpServletRequest.class);
        doReturn(null).when(mockRequest).getRequestURI();
        Exception mockException = mock(Exception.class);
        doReturn("message").when(mockException).getMessage();

        ResponseEntity<ErrorDto> response = sut.handleException(mockRequest, mockException);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

    }

    @Test
    void whenMissingServletRequestParameterExceptionIsTrowed_thenMissingServletRequestParameterException(){

        HttpServletRequest mockRequest = mock(HttpServletRequest.class);
        doReturn(null).when(mockRequest).getRequestURI();
        MissingServletRequestParameterException mockException = mock(MissingServletRequestParameterException.class);
        doReturn("message").when(mockException).getMessage();

        ResponseEntity<ErrorDto> response = sut.handleMissingServletRequestParameterException(mockRequest, mockException);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

    }
    @Test
    void whenValidationExceptionIsTrowed_thenValidationException(){

        HttpServletRequest mockRequest = mock(HttpServletRequest.class);
        doReturn(null).when(mockRequest).getRequestURI();
        ValidationException mockException = mock(ValidationException.class);
        doReturn("message").when(mockException).getMessage();

        ResponseEntity<ErrorDto> response = sut.handleValidationException(mockRequest, mockException);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}