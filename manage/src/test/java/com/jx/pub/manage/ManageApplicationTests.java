package com.jx.pub.manage;


import com.jx.pub.common.pojo.Admin;
import com.jx.pub.common.util.IDUtil;
import com.jx.pub.common.util.TimeUtil;
import com.jx.pub.manage.mapper.AdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ManageApplicationTests {

    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void testMD5() {
        String s = DigestUtils.md5DigestAsHex("123456".getBytes());
        System.out.println(s);
    }

    @Test
    public void testUUID() {
        String uuid = IDUtil.getUUID();
        System.out.println(uuid.length()+":"+uuid);
    }

    @Test
    public void testTimeUtil() {
        System.out.println(TimeUtil.getNowData());
        System.out.println(TimeUtil.getNowTime());
    }
}
