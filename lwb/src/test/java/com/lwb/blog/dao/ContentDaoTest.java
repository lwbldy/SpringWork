package com.lwb.blog.dao;

import com.lwb.blog.domain.ContentDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContentDaoTest {

    @Autowired
    ContentDao contentDao;

    @Test
    public void get() throws Exception {
        ContentDO contentDO = contentDao.get(75l);
        System.out.println(contentDO);
    }

}