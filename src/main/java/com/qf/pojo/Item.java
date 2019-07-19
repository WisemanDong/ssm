package com.qf.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @BelongsProject: day06-ssm
 * @BelongsPackage: com.qf.pojo
 * @Author: WisemanDong
 * @CreateTime: 2019-07-18 14:27
 * @Description: todo
 */
@Data
public class Item {

    //id
    private Long id;
    //商品名称
    @NotBlank(message = "商品名称为必填项,岂能为空!")
    private String name;
    //商品价格
    @NotNull(message = "商品价格为必填项,岂能为空!")
    private BigDecimal price;
    //商品的生产日期.
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "商品的生产日期为必填项,岂能为空!")
    private Date productionDate;
    //商品的描述
    @NotBlank(message = "商品的描述为必填项,岂能为空!")
    private String description;
    //商品的图片
    private String pic;
    //商品的创建时间
    private Date created;

}
