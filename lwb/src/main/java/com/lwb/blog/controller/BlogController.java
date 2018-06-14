package com.lwb.blog.controller;

import com.lwb.blog.domain.ContentDO;
import com.lwb.blog.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/blog")
@Controller
public class BlogController {

    @Autowired
    ContentService bContentService;

    @RequestMapping("/{id}")
    @ResponseBody
    public ContentDO findById(@PathVariable("id") long id){
        System.out.println("--------------------->>"+id);
        return bContentService.get(id);
    }


}
