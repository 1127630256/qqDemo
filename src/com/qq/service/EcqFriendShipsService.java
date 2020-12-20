package com.qq.service;

public interface EcqFriendShipsService {
    /** 增加好友*/
    Boolean insertEcqFriend(long HostId, long FriendId);

    /** 删除好友*/
    Boolean deleteEcqFriend(long HostId, long FriendId);
}
