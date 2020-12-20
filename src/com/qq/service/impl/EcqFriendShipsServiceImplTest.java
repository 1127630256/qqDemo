package com.qq.service.impl;

import com.qq.service.EcqFriendShipsService;
import com.qq.util.BeanFactory;
import org.junit.Before;
import org.junit.Test;

public class EcqFriendShipsServiceImplTest {
    private EcqFriendShipsService ecqFriendShipsService;

    @Before
    public void setUp() throws Exception {
        ecqFriendShipsService= BeanFactory.getBean(EcqFriendShipsServiceImpl.class);
    }

    @Test
    public void insertEcqFriend() {
        ecqFriendShipsService.insertEcqFriend(10001,10003);
        ecqFriendShipsService.insertEcqFriend(10001,10007);
        ecqFriendShipsService.insertEcqFriend(10001,10008);
        ecqFriendShipsService.insertEcqFriend(10001,10009);
        ecqFriendShipsService.insertEcqFriend(10001,10010);
        ecqFriendShipsService.insertEcqFriend(10001,10011);

    }

    @Test
    public void deleteEcqFriend() {
        ecqFriendShipsService.deleteEcqFriend(10003,10011);
    }
}