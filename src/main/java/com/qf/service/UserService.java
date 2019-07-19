package com.qf.service;

import com.qf.pojo.User;

/**
 * @BelongsProject: Java1904P3
 * @BelongsPackage: com.qf.service
 * @Author: WisemanDong
 * @CreateTime: 2019-07-15 15:06
 * @Description: todo
 */
public interface UserService {

    //根据用户名处查询是否可用
    Integer checkUsername(String username);

    //注册功能
    Integer register(User user);

    //执行登录
    User login(String username,String password);

}
