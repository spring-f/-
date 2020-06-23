package com.tensquare.entity;

import lombok.Data;

@Data
public class Result {
    private boolean flag;
    private Integer code;
    private String message;
    private Object date;

    public Result(boolean flag, Integer code, String message, Object date) {
        super();
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.date = date;
    }

    public Result(boolean flag, Integer code, String message) {
        super();
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result() {
    }
}
