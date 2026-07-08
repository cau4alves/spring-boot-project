package br.com.caua.spring_boot_project.handler;

import br.com.caua.spring_boot_project.exception.ErrorResponse;
import br.com.caua.spring_boot_project.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException x) {
        ErrorResponse response = ErrorResponse.builder()
                .message(x.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
