package com.qq.service.impl;

import com.qq.dao.EcqUsersDao;
import com.qq.dao.impl.EcqUsersDaoImpl;
import com.qq.entity.EcqUsers;
import com.qq.service.EcqUsersService;

import java.util.Date;
import java.util.List;

public class EcqUserServiceImpl implements EcqUsersService {
    private EcqUsersDao ecqUsersDao;
    public EcqUserServiceImpl(){
        ecqUsersDao = new EcqUsersDaoImpl();
    }
    @Override
    public boolean BuddyListener(EcqUsers ecqUsers) throws Exception {
        ecqUsers.setState(1);
        ecqUsers.setFacepath("null");
        ecqUsers.setRgedate(new Date());
        ecqUsers.setFriendpolicy(null);
        boolean count = ecqUsersDao.BuddyListener(ecqUsers);
        return count;
    }

    @Override
    public List<EcqUsers> findAllFriend(Integer userId) {
        List<EcqUsers> allFriend = ecqUsersDao.findAllFriend(userId);
        return allFriend;
    }

    @Override
    public EcqUsers findNameAndFace(String name) {
        EcqUsers nameAndFace = ecqUsersDao.findNameAndFace(name);
        return nameAndFace;
    }

    public EcqUsers selectByNameAndPwd(String userName, String pwd){
        return ecqUsersDao.selectByNameAndPwd(userName, pwd);
    }

    public EcqUsers selectByNameAndMemo(String userName,String memo){
        return ecqUsersDao.selectByNameAndMemo(userName,memo);
    }

    @Override
    public boolean updatePwd(String userName, String pwd) {
        return ecqUsersDao.updatePwd(userName,pwd);
    }
}
