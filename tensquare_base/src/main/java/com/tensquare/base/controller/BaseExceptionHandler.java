package com.tensquare.base.controller;

import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BaseExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result error(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR,e.getMessage());
    }
}
