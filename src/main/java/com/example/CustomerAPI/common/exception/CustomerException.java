package com.example.CustomerAPI.common.exception;

public class CustomerException extends RuntimeException{
    public CustomerException(String reason, Throwable cause){
        super(reason, cause);
    }

}
