package com.dbank.dbankoperationservice.exception.handler;

import com.dbank.dbankoperationservice.exception.message.ExceptionMessages;
import com.dbank.dbankoperationservice.exception.UserAccountNotFoundException;
import com.dbank.dbankoperationservice.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AccountAdvice {

    @ExceptionHandler(UserAccountNotFoundException.class)
    public ResponseEntity<String> accountNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ExceptionMessages.USER_ACCOUNT_NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> userNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ExceptionMessages.USER_NOT_FOUND);
    }

}
