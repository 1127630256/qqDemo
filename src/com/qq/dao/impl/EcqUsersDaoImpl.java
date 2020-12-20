package com.qq.dao.impl;

import com.qq.dao.BaseDao;
import com.qq.dao.EcqUsersDao;
import com.qq.entity.EcqBlood;
import com.qq.entity.EcqStar;
import com.qq.entity.EcqUsers;
import com.qq.util.EmptyUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EcqUsersDaoImpl extends BaseDao<EcqUsers> implements EcqUsersDao {
    @Override
    public EcqUsers mappingEntity(ResultSet resultSet) throws SQLException {
        EcqUsers ecqUsers = new EcqUsers();
        EcqBlood ecqBlood= new EcqBlood();
        EcqStar ecqStar= new EcqStar();
        ecqUsers.setUserid(resultSet.getLong("Userid"));
        ecqUsers.setNickname(resultSet.getString("Nickname"));
        ecqUsers.setLoginpwd(resultSet.getString("Loginpwd"));
        ecqUsers.setState(resultSet.getInt("State"));
        ecqUsers.setFacepath(resultSet.getString("Facepath"));
        ecqUsers.setRgedate(resultSet.getDate("Rgedate"));
        ecqUsers.setAge(resultSet.getInt("Age"));
        ecqUsers.setSex(resultSet.getString("Sex"));
        ecqUsers.setStar(resultSet.getInt("Star"));
        ecqUsers.setBlood(resultSet.getInt("Blood"));
        ecqUsers.setRealname(resultSet.getString("Realname"));
        ecqUsers.setFriendpolicy(resultSet.getInt("Friendpolicy"));
        ecqUsers.setMemo(resultSet.getString("memo"));
        ecqBlood.setMemo(resultSet.getString("bm"));
        ecqStar.setStarname(resultSet.getString("sn"));
        ecqUsers.setEcqBlood(ecqBlood);
        ecqUsers.setEcqStar(ecqStar);
        return ecqUsers;
    }
    @Override
    public List<EcqUsers> selectAll() {
        String sql="select u.*,b.memo bm,s.starName sn  from ecq_users u left join ecq_star s on (u.Star=s.StarId) left join ecq_blood b on(u.Blood=b.BloodId);";
        List<EcqUsers> ecqUsers = executeQuery(sql);
        return ecqUsers;
    }

    @Override
    public EcqUsers selectByNameAndPwd(String userName, String pwd) {
        String sql="select u.*,b.memo bm,s.starName sn from ecq_users u left join ecq_star s on (u.Star=s.StarId) left join ecq_blood b on(u.Blood=b.BloodId) where Nickname=? and Loginpwd=?";
        List<EcqUsers> ecqUsers = executeQuery(sql, userName, pwd);
        return EmptyUtil.isEmpty(ecqUsers)?null:ecqUsers.get(0);
    }

    @Override
    public EcqUsers selectByName(String userName) {
        String sql="select u.*,b.memo bm,s.starName sn from ecq_users u left join ecq_star s on (u.Star=s.StarId) left join ecq_blood b on(u.Blood=b.BloodId) where NickName=?";
        List<EcqUsers> ecqUsers = executeQuery(sql,userName);
        return EmptyUtil.isEmpty(ecqUsers)?null:ecqUsers.get(0);
    }

    @Override
    public EcqUsers selectByNameAndMemo(String userName, String memo) {
        String sql="select u.*,b.memo bm,s.starName sn from ecq_users u left join ecq_star s on (u.Star=s.StarId) left join ecq_blood b on(u.Blood=b.BloodId) where NickName=? and u.memo=?";
        List<EcqUsers> ecqUsers = executeQuery(sql,userName,memo);
        return EmptyUtil.isEmpty(ecqUsers)?null:ecqUsers.get(0);
    }

    @Override
    public List<EcqUsers> selectByNickName(String nickName) {
        String sql="select u.*,b.memo bm,s.starName sn from ecq_users u,ecq_star s,ecq_blood b where u.Star=s.StarId and u.Blood=b.BloodId and nickName like ?";
        nickName="%"+nickName+"%";
        List<EcqUsers> ecqUsers = executeQuery(sql, nickName);
        return ecqUsers;
    }

    @Override
    public List<EcqUsers> findAllFriend(Integer userId) {
        String sql = "SELECT u.*,b.memo bm,s.starName sn  from ecq_users u,ecq_star s,ecq_blood b where u.Star=s.StarId And u.Blood=b.BloodId And UserId in (select friendId from ecq_friend_ships,ecq_users where HostId = ?)";
        List<EcqUsers> ecqUsers = executeQuery(sql, userId);
        return EmptyUtil.isEmpty(ecqUsers) ?null:ecqUsers;
    }

    @Override
    public boolean BuddyListener(EcqUsers ecqUsers) throws Exception {
        String sql = "insert into ecq_users values(default,?,?,?,?,?,?,?,?,?,?,?,?);";
        int count = executeUpdate(sql, ecqUsers.getNickname(), ecqUsers.getLoginpwd(), ecqUsers.getState(), ecqUsers.getFacepath(),
                ecqUsers.getRgedate(), ecqUsers.getAge(), ecqUsers.getSex(), ecqUsers.getStar(),
                ecqUsers.getBlood(), ecqUsers.getRealname(), ecqUsers.getFriendpolicy(), ecqUsers.getMemo());
        return count != 0;
    }

    @Override
    public EcqUsers findNameAndFace(String name) {
        String sql = "SELECT u.*,b.memo bm,s.starName sn  from ecq_users u,ecq_star s,ecq_blood b where u.Star=s.StarId And u.Blood=b.BloodId And nickName = ?";
        List<EcqUsers> ecqUsers = executeQuery(sql, name);
        return EmptyUtil.isEmpty(ecqUsers) ? null : ecqUsers.get(0);
    }

    @Override
    public boolean updatePwd(String userName, String pwd) {
        String sql="update ecq_users set loginpwd=? where NickName=?";
        int i = 0;
        i = executeUpdate(sql, pwd, userName);

        return i>0?true:false;
    }


}




