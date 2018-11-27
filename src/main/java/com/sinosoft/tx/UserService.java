package com.sinosoft.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hoverkan
 * @create 2018-11-27 9:13
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void insertUser(){
        userDao.insert();
        System.out.println("插入用户完毕！");

        int i = 10;
        System.out.println(i/0);
    }

}
