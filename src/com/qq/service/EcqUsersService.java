package com.qq.service;

import com.qq.entity.EcqUsers;

import java.util.List;

public interface EcqUsersService {
    /**添加用户*/
    boolean BuddyListener(EcqUsers ecqUsers) throws Exception;

    /**查询所有好友*/
    List<EcqUsers> findAllFriend(Integer userId);

    /**查询登入用户名*/
    EcqUsers findNameAndFace(String name);


    /** 根据账号密码查询用户 */
    EcqUsers selectByNameAndPwd(String userName, String pwd);

    /** 根据账号和密保查询  */
    EcqUsers selectByNameAndMemo(String userName,String memo);

    /** 更新密码 */
    boolean updatePwd(String userName,String pwd);
}
