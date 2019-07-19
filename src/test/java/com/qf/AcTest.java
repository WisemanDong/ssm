package com.qf;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @BelongsProject: Java1904P3
 * @BelongsPackage: com.qf
 * @Author: WisemanDong
 * @CreateTime: 2019-07-12 11:27
 * @Description: todo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:applicationContext-dao.xml",
        "classpath:applicationContext-service.xml"
})
public class AcTest {
}
