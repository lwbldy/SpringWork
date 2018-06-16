package com.lwb.blog.dao;

import com.lwb.blog.domain.ContentDO;
import com.lwb.system.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContentDaoTest {

    @Autowired
    ContentDao contentDao;

    @Autowired
    UserDao userDao;

    @Test
    public void get() throws Exception {
        ContentDO contentDO = contentDao.get(75l);
        System.out.println(contentDO);
    }

    @Test
    public void getUser(){
        Map<String ,Object> map = new HashMap<>();
        map.put("username", "admin");
        System.out.println(userDao.list(map).size());
    }

}