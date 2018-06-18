package com.lwb.system.dao;

import com.lwb.system.domain.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void get() throws Exception {
        UserDO userDO = userDao.get(1l);
        System.out.println(userDO.toString());
    }

}