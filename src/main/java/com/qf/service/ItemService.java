package com.qf.service;

import com.qf.pojo.Item;
import com.qf.util.PageInfo;

/**
 * @BelongsProject: day06-ssm
 * @BelongsPackage: com.qf.service
 * @Author: WisemanDong
 * @CreateTime: 2019-07-18 15:06
 * @Description: todo
 */
public interface ItemService {

    //分页查询商品信息
    PageInfo<Item> findItemByNameLikeAndLimit(String name, Integer page, Integer size);

    //添加商品
    Integer save(Item item);

    //根据id删除商品
    Integer del(Long id);
}
