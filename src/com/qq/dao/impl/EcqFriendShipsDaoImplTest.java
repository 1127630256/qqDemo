package com.qq.dao.impl;

import com.qq.dao.EcqFriendShipsDao;
import org.junit.Before;
import org.junit.Test;


public class EcqFriendShipsDaoImplTest {
    private EcqFriendShipsDao ecqFriendShipsDao;

    @Before
    public void setUp() throws Exception {
        ecqFriendShipsDao = new EcqFriendShipsDaoImpl();
    }

    @Test
    public void insertEcqFriend() {
        Boolean aBoolean = ecqFriendShipsDao.insertEcqFriend(10001, 10009);
        System.out.println(aBoolean);
    }

    @Test
    public void deleteEcqFriend() {
        Boolean aBoolean = ecqFriendShipsDao.deleteEcqFriend(10001, 10009);
        System.out.println(aBoolean);
    }

    @Test
    public void mappingEntity() {
    }
}
