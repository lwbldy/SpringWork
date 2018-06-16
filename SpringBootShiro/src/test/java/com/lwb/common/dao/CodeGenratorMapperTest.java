package com.lwb.common.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeGenratorMapperTest {

    @Autowired
    CodeGenratorMapper codeGenratorMapper;


    @Test
    public void listColumns() throws Exception {

        List<Map<String, String>> codeColl = codeGenratorMapper.listColumns("blog_content");
        System.out.println(codeColl.size());

    }

}