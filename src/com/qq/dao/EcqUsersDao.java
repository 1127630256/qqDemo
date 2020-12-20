package com.qq.dao;

import com.qq.entity.EcqUsers;

import java.util.List;

public interface EcqUsersDao {

    /** 查询全部用户 */
    List<EcqUsers> selectAll();

    /** 通过账号密码查询用户 */
    EcqUsers selectByNameAndPwd(String userName, String pwd);

    /** 通过账号查询用户*/
    EcqUsers selectByName(String userName);

    /** 通过名字和密保信息查询用户*/
    EcqUsers selectByNameAndMemo(String userName, String memo);

    /**通过名字模糊查询好友*/
    List<EcqUsers> selectByNickName(String nickName);


    /**查询所有好友*/
    List<EcqUsers> findAllFriend(Integer userId);

    /**添加用户*/
    boolean BuddyListener(EcqUsers ecqUsers) throws Exception;

    /**查询用户名*/
    EcqUsers findNameAndFace(String name);

    /**更新密码*/
    boolean updatePwd(String userName,String pwd);

}
