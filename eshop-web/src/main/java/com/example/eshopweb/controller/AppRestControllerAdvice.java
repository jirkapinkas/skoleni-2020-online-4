package com.example.eshopweb.controller;

import com.example.eshopweb.exception.DeleteException;
import com.example.eshopweb.exception.NotFoundException;
import com.example.eshopweb.pojo.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppRestControllerAdvice {

    // https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc

    @ExceptionHandler
    public ResponseEntity<Message> handleNotFoundException(NotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new Message(e.getMessage(), 404));
    }

    @ExceptionHandler
    public ResponseEntity<Message> handleDeleteException(DeleteException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new Message(e.getMessage(), 400));
    }

//    @ExceptionHandler
//    public ResponseEntity<Message> handleGenericException(Exception e) {
//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(new Message(e.getMessage(), 500));
//    }

}
