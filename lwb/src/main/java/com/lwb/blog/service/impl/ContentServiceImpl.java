package com.lwb.blog.service.impl;

import com.lwb.blog.dao.ContentDao;
import com.lwb.blog.domain.ContentDO;
import com.lwb.blog.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentDao bContentMapper;

    @Override
    public ContentDO get(Long cid){
        return bContentMapper.get(cid);
    }


}
