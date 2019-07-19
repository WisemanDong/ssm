package com.qf.service;

import com.qf.AcTest;
import com.qf.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @BelongsProject: day06-ssm
 * @BelongsPackage: com.qf.service
 * @Author: WisemanDong
 * @CreateTime: 2019-07-15 23:23
 * @Description: todo
 */
public class UserServiceTest extends AcTest {

    @Autowired
    private UserService userService;

    @Test
    public void checkUsername() {

        Integer count = userService.checkUsername("admin");

        System.out.println(count);

    }

    @Test
    @Transactional
    public void register(){
        User user = new User();
        user.setUsername("xxxxx");
        user.setPassword("xxxxx");
        user.setPhone("11111111111");

        Integer count = userService.register(user);
        assertEquals(new Integer(1),count);
    }

    @Test
    public void login(){
        User user = userService.login("admin", "admin");
        System.out.println(user);
    }

}