package com.qq.service.impl;

import com.qq.entity.EcqUsers;
import com.qq.service.EcqUsersService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class EcqUserServiceImplTest {
    private EcqUsersService ecqUsersDao;

    @Before
    public void setUp() throws Exception {
        ecqUsersDao = new EcqUserServiceImpl();
    }

    @Test
    public void buddyListener() throws Exception {
        EcqUsers ecqUsers = new EcqUsers();
        ecqUsers.setNickname("刘大傻");
        ecqUsers.setAge(33);
        ecqUsers.setSex("女");
        ecqUsers.setLoginpwd("admin");
        ecqUsers.setRealname("大傻");
        ecqUsers.setStar(3);
        ecqUsers.setBlood(2);
        ecqUsers.setMemo("刘");
        boolean b = ecqUsersDao.BuddyListener(ecqUsers);
        System.out.println(b);
    }

    @Test
    public void findAllFriend() {
        List<EcqUsers> allFriend = ecqUsersDao.findAllFriend(10001);
        allFriend.forEach(System.out::println);
    }

    @Test
    public void findNameAndFace() {
        EcqUsers w = ecqUsersDao.findNameAndFace("泰戈尔");
        System.out.println(w);

    }
}