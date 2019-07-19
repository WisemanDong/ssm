package com.qf.mapper;

import com.qf.AcTest;
import com.qf.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @BelongsProject: Java1904P3
 * @BelongsPackage: com.qf.mapper
 * @Author: WisemanDong
 * @CreateTime: 2019-07-15 15:06
 * @Description: todo
 */
public class UserMapperTest extends AcTest {

    @Autowired
    private  UserMapper userMapper;

    @Test
    public void findCountByUsername() {

        Integer count = userMapper.findCountByUsername("admin");
        System.out.println(count);

    }

    @Test
    @Transactional
    public void save(){
        User user = new User();
        user.setUsername("xxxxx");
        user.setPassword("xxxxx");
        user.setPhone("11110000000");

        Integer count = userMapper.save(user);

        assertEquals(new Integer(1),count);

    }

    @Test
    public void findByUsername(){
        User user = userMapper.findByUsername("admin");
        System.err.println(user);
    }

}