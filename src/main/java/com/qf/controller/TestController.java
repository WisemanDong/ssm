package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @BelongsProject: day06-ssm
 * @BelongsPackage: com.qf.controller
 * @Author: WisemanDong
 * @CreateTime: 2019-07-18 21:18
 * @Description: todo
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @PutMapping("update")
    public String update(String name,Integer age){
        return null;
    }

}
