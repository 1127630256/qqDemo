package com.qq.dao.impl;
import com.qq.entity.EcqUsers;
import com.qq.util.BeanFactory;
import org.junit.Test;

import java.util.List;


public class EcqUsersDaoImplTest {


    @Test
    public void selectAll() {
        EcqUsersDaoImpl bean = BeanFactory.getBean(EcqUsersDaoImpl.class);
        List<EcqUsers> ecqUsers = bean.selectAll();
        ecqUsers.forEach(System.out::println);
    }

    @Test
    public void selectByNameAndPwd() {
        EcqUsersDaoImpl bean = BeanFactory.getBean(EcqUsersDaoImpl.class);
        EcqUsers ecqUsers = bean.selectByNameAndPwd("居里夫人", "jlfr");
        System.out.println(ecqUsers);
    }

    @Test
    public void selectByName() {
        EcqUsersDaoImpl bean = BeanFactory.getBean(EcqUsersDaoImpl.class);
        EcqUsers user= bean.selectByName("居里夫人");
        System.out.println(user);
    }

    @Test
    public void selectByUserIdAndFriendId(){
        EcqUsersDaoImpl bean = BeanFactory.getBean(EcqUsersDaoImpl.class);
        List<EcqUsers> ecqUsers = bean.selectByNickName("青");
        ecqUsers.forEach(System.out::println);
    }

    @Test
    public void findAllFriend(){
        EcqUsersDaoImpl bean = BeanFactory.getBean(EcqUsersDaoImpl.class);
        List<EcqUsers> allFriend = bean.findAllFriend(10001);
        allFriend.forEach(System.out::println);
    }
}
