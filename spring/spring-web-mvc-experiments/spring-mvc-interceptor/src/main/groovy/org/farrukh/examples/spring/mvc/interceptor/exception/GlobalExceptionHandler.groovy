package org.farrukh.examples.spring.mvc.interceptor.exception

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.HttpMediaTypeNotSupportedException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

/**
 * Created by Farrukhjon on 5/12/15.
 */
@ControllerAdvice
class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        handleHttpMediaTypeNotSupported(ex, headers, status, request)
    }

    @ExceptionHandler(RuntimeException)
    public ResponseEntity<String> handleNullContentType(RuntimeException e){
        new ResponseEntity<>(e.message, HttpStatus.BAD_REQUEST)
    }
}
