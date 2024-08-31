package com.example.kollektivet.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

//Further exception handling will be placed underneath
@ResponseStatus
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }

}
