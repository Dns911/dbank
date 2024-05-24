package com.dbank.dbankoperationservice.exception.handler;

import com.dbank.dbankoperationservice.exception.CardNotExistException;
import com.dbank.dbankoperationservice.exception.message.ExceptionMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CardAdvice {

    @ExceptionHandler(CardNotExistException.class)
    public ResponseEntity<String> cardNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ExceptionMessages.CARD_NOT_FOUND);
    }
}
