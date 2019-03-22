package ru.zaa.springboot.multidatasource.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No found person")
public class PersonNotFoundException extends RuntimeException{
}
