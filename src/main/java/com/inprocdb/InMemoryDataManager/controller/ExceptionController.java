package com.inprocdb.InMemoryDataManager.controller;

import com.inprocdb.InMemoryDataManager.exception.InvalidInputException;
import com.inprocdb.InMemoryDataManager.exception.PersonNotfoundException;
import com.inprocdb.InMemoryDataManager.exception.ServerErrorException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(PersonNotfoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String personNotFoundHandler(PersonNotfoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(InvalidInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String invalidInputHandler(InvalidInputException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String internalServerHandler(ServerErrorException ex) {
        return ex.getMessage();
    }

}
