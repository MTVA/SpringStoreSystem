package com.marcosaragao.springgoodpraticescourse.services.exceptions;

public class GameTreeException extends RuntimeException {

    public GameTreeException(String msg){
        super(msg);
    }

    public GameTreeException(String msg, Throwable cause){
        super(msg, cause);
    }
}
