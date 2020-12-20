package com.qq.service.impl;

import com.qq.dao.EcqFriendShipsDao;
import com.qq.dao.impl.EcqFriendShipsDaoImpl;
import com.qq.service.EcqFriendShipsService;
import com.qq.util.BeanFactory;

/**
 * @date 2020-12-20 13:55
 */
public class EcqFriendShipsServiceImpl implements EcqFriendShipsService {
    EcqFriendShipsDao ecqFriendShipsDao= BeanFactory.getBean(EcqFriendShipsDaoImpl.class);
    @Override
    public Boolean insertEcqFriend(long HostId, long FriendId) {
        return ecqFriendShipsDao.insertEcqFriend(HostId,FriendId);
    }

    @Override
    public Boolean deleteEcqFriend(long HostId, long FriendId) {
        return ecqFriendShipsDao.deleteEcqFriend(HostId,FriendId);
    }
}
