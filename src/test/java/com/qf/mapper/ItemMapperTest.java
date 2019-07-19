package com.qf.mapper;

import com.qf.AcTest;
import com.qf.pojo.Item;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @BelongsProject: day06-ssm
 * @BelongsPackage: com.qf.mapper
 * @Author: WisemanDong
 * @CreateTime: 2019-07-18 14:47
 * @Description: todo
 */
public class ItemMapperTest extends AcTest {

    @Autowired
    private ItemMapper itemMapper;

    @Test
    public void findCountByName() {
        Long count = itemMapper.findCountByName("a");
        System.out.println(count);
    }

    @Test
    public void findItemByNameLikeAndLimit() {
        List<Item> a = itemMapper.findItemByNameLikeAndLimit("a", 1, 2);
        for (Item item : a) {
            System.out.println(item);
        }
    }

    @Test
    @Transactional
    public void save(){
        Item item = new Item();
        item.setName("xxxx");
        item.setPrice(new BigDecimal(1.2));
        item.setProductionDate(new Date());
        item.setDescription("yyyyyyyyyyyyy");
        item.setPic("zzzzzzzzzzzzzz");

        Integer count = itemMapper.save(item);

        assertEquals(new Integer(1),count);
    }

    @Test
    @Transactional
    public void del(){
        Integer count = itemMapper.delById(16L);
        assertEquals(new Integer(1),count);
    }

}