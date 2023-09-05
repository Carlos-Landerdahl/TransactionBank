package com.transactionalBank.demo.controllers.handlers;

import com.transactionalBank.demo.dto.CustomError;
import com.transactionalBank.demo.dto.ValidationError;
import com.transactionalBank.demo.servicies.exceptions.DatabaseException;
import com.transactionalBank.demo.servicies.exceptions.InsufficientBalanceException;
import com.transactionalBank.demo.servicies.exceptions.InvalidUserTypeException;
import com.transactionalBank.demo.servicies.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExcepitionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status.value()).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomError> databaseException(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status.value()).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError err = new ValidationError(Instant.now(), status.value(), "Dados inválidos", request.getRequestURI());
        for(FieldError f : e.getBindingResult().getFieldErrors()) {
            err.addError(f.getField(), f.getDefaultMessage());
        }
        return ResponseEntity.status(status.value()).body(err);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<CustomError> handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT; // ou HttpStatus.BAD_REQUEST, dependendo da sua preferência.
        CustomError err = new CustomError(Instant.now(), status.value(), "Os dados fornecidos já existem no sistema", request.getRequestURI());
        return ResponseEntity.status(status.value()).body(err);
    }

    @ExceptionHandler(InvalidUserTypeException.class)
    public ResponseEntity<CustomError> handleInvalidUserTypeException(InvalidUserTypeException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.FORBIDDEN;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status.value()).body(err);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<CustomError> handleInsufficientBalanceException(InsufficientBalanceException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status.value()).body(err);
    }
}
