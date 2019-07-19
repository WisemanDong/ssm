package com.qf.service;

import com.qf.AcTest;
import com.qf.pojo.Item;
import com.qf.util.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @BelongsProject: day06-ssm
 * @BelongsPackage: com.qf.service
 * @Author: WisemanDong
 * @CreateTime: 2019-07-18 19:56
 * @Description: todo
 */
public class ItemServiceTest extends AcTest {

    @Autowired
    private ItemService itemService;

    @Test
    public void findItemByNameLikeAndLimit() {

        PageInfo<Item> pageInfo = itemService.findItemByNameLikeAndLimit(null, 1, 10);
        System.out.println(pageInfo);
        for (Item item:pageInfo.getList()){
            System.out.println(item);
        }

    }

    @Test
    @Transactional
    public void save() {

        Item item = new Item();
        item.setName("xxxx");
        item.setPrice(new BigDecimal(1.2));
        item.setProductionDate(new Date());
        item.setDescription("yyyyyyyyyyyyy");
        item.setPic("zzzzzzzzzzzzzz");

        Integer count = itemService.save(item);

        assertEquals(new Integer(1),count);

    }

    @Test
    @Transactional
    public void del(){
        Integer count = itemService.del(16L);
        assertEquals(new Integer(1),count);
    }

}