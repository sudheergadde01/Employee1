package com.practice.employee.exceptions;

import com.practice.employee.response.EmployeeResponse;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<EmployeeResponse> handleEmployeeNotFound(EmployeeNotFoundException exception){
        EmployeeResponse response = new EmployeeResponse();
        response.setStatus(404);
        response.setMessage("Employee not found with the given ID");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<EmployeeResponse> handleArgumentNotValid(MethodArgumentNotValidException exception){

        EmployeeResponse response= new EmployeeResponse();
        response.setStatus(400);
        String errorMessage = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .findFirst()
                .orElse("Invalid input");

        response.setMessage(errorMessage);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
