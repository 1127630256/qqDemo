package com.qq.dao;



public interface EcqFriendShipsDao {
    /** 添加好友*/
    Boolean insertEcqFriend(long HostId, long FriendId);

    /**删除好友*/
    Boolean deleteEcqFriend(long HostId, long FriendId);
}
