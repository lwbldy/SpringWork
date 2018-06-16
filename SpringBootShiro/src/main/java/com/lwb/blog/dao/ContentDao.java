package com.lwb.blog.dao;

import com.lwb.blog.domain.ContentDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 文章内容
 * @author chglee
 */
@Mapper
public interface ContentDao {

    ContentDO get(Long cid);

    List<ContentDO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(ContentDO content);

    int update(ContentDO content);

    int remove(Long cid);

    int batchRemove(Long[] cids);
}

