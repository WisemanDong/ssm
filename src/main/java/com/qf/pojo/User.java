package com.qf.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * @BelongsProject: Java1904P3
 * @BelongsPackage: com.qf.pojo
 * @Author: WisemanDong
 * @CreateTime: 2019-07-15 14:32
 * @Description: user表映射的实体类
 */
@Data
public class User {

    private Long id;

    @NotBlank(message = "用户名为必填项,岂能不填!!!")
    private String username;

    @NotBlank(message = "密码为必填项,岂能不填!!!")
    private String password;

    @NotBlank(message = "手机号为必填项,岂能不填!!!")
    private String phone;

    private Date created;

}
