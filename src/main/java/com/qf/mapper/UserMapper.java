package com.qf.mapper;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @BelongsProject: Java1904P3
 * @BelongsPackage: com.qf.mapper
 * @Author: WisemanDong
 * @CreateTime: 2019-07-15 10:50
 * @Description: todo
 */
public interface UserMapper {

    //1.根据用户名查询数据条数
    Integer findCountByUsername(@Param("username")String username);

    //2.添加用户信息
    Integer save(User user);


    //3.根据用户名查询用户信息.
    User findByUsername(@Param("username")String username);

}
