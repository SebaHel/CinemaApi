package com.example.MovieService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FilmAdvice {


    @ExceptionHandler(MovieBadRequestException.class)
    public ResponseEntity<String> handleExeption(MovieBadRequestException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("400" + ex.getLocalizedMessage());
    }
    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<String> handleExeption(MovieNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("404" + ex.getLocalizedMessage());
    }
}
