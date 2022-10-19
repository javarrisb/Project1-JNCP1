package com.company.Summative1CristieJBNicholas.controller;

import com.company.Summative1CristieJBNicholas.models.CustomResponse;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.webjars.NotFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ConsoleCustomResponseController {

    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<CustomResponse> outOfRangeException(IllegalArgumentException e) {
        CustomResponse error = new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY.toString(), e.getMessage());
        error.setTimestamp(LocalDateTime.now());
        error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        ResponseEntity<CustomResponse> responseEntity = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    @ExceptionHandler(value = {ChangeSetPersister.NotFoundException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<CustomResponse> itemNotFound(ChangeSetPersister.NotFoundException e) {
        CustomResponse error = new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY.toString(), e.getMessage());
        error.setTimestamp(LocalDateTime.now());
        error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        ResponseEntity<CustomResponse> responseEntity = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }
}
