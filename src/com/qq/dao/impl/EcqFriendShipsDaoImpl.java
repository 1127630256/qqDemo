package com.qq.dao.impl;

import com.qq.dao.BaseDao;
import com.qq.dao.EcqFriendShipsDao;
import com.qq.entity.EcqFriendShips;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @date 2020-12-19 22:59
 */
public class EcqFriendShipsDaoImpl extends BaseDao<EcqFriendShips> implements EcqFriendShipsDao {
    /**
     * 添加好友
     */
    @Override
    public Boolean insertEcqFriend(long HostId, long FriendId) {
        String sql="insert into ecq_friend_ships values(default,?,?,1,?,'好友')";
        int count = executeUpdate(sql, HostId, FriendId, new Date());
        return count != 0;
    }

    /**
     * 删除好友
     * @param HostId
     * @param FriendId
     * @return
     */
    public Boolean deleteEcqFriend(long HostId, long FriendId){
        String sql="delete from ecq_friend_ships where HostId=? and FriendId = ?";
        int count = executeUpdate(sql, HostId, FriendId);
        return count != 0;
    }




    @Override
    public EcqFriendShips mappingEntity(ResultSet resultSet) throws SQLException {
        EcqFriendShips ecqFriendShips=new EcqFriendShips();
        ecqFriendShips.setShipid(resultSet.getLong(1));
        ecqFriendShips.setHostid(resultSet.getLong(2));
        ecqFriendShips.setFriendid(resultSet.getLong(3));
        ecqFriendShips.setShiptype(resultSet.getInt(4));
        ecqFriendShips.setCreatedate(resultSet.getDate(5));
        ecqFriendShips.setMemo(resultSet.getString(6));
        return ecqFriendShips;
    }
}
