package com.qf.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: Java1904P3
 * @BelongsPackage: com.qf.vo
 * @Author: WisemanDong
 * @CreateTime: 2019-07-15 14:52
 * @Description: todo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO {

    private Integer code;

    private String msg;

    private Object data;

}
