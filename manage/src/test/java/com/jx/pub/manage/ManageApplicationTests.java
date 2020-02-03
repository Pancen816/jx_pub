package com.jx.pub.manage;


import com.jx.pub.common.util.IDUtil;
import com.jx.pub.common.util.TimeUtil;
import com.jx.pub.manage.mapper.RoomTypeMapper;
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
    private RoomTypeMapper roomTypeMapper;

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
        System.out.println(TimeUtil.getRoomBeginTime());
        System.out.println(TimeUtil.getRoomEndTime());
    }

    @Test
    public void testTime() {
        String beginTime = TimeUtil.getRoomBeginTime();
        String endTime = TimeUtil.getRoomEndTime();
        System.out.println(beginTime.compareTo(endTime)); // 小于 -1
        System.out.println(endTime.compareTo(endTime)); // 等于 0
        System.out.println(endTime.compareTo(beginTime)); // 大于 1
    }

    @Test
    public void testRoomTypeMapper() {
        int typeMaxPeopleById = roomTypeMapper.getTypeMaxPeopleById("0d6ffcacfd04495480e701ed8d9f06c9");
        System.out.println(typeMaxPeopleById);
    }
}
