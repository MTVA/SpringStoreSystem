package com.marcosaragao.springgoodpraticescourse.resource.exception;

import lombok.Getter;
import lombok.Setter;

public class StandardError {

    @Getter
    @Setter
    private Integer status;

    @Getter
    @Setter
    private String msg;

    @Getter
    @Setter
    private Long timeStamp;

    public StandardError(Integer status, String msg, Long timeStamp) {
        this.status = status;
        this.msg = msg;
        this.timeStamp = timeStamp;
    }
}
