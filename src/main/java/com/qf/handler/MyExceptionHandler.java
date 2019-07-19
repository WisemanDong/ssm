package com.qf.handler;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @BelongsProject: day06-ssm
 * @BelongsPackage: com.qf.handler
 * @Author: WisemanDong
 * @CreateTime: 2019-07-18 20:42
 * @Description: todo
 */
@ControllerAdvice
@Component
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String ex(Exception ex){
        ex.printStackTrace();
        return "error";
    }

}
