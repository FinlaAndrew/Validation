package com.UST.EmployeeformPractice.exception;
import com.UST.EmployeeformPractice.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler{
    @ExceptionHandler(value = IdNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleException(IdNotFoundException ex){
        ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
   }

   @ExceptionHandler(value = NameFoundException.class)
   public ResponseEntity<ErrorMessage> handleException2(NameFoundException ex){
      ErrorMessage error = new ErrorMessage(HttpStatus.CONFLICT,ex.getMessage());
       return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
   }

   @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }



}
