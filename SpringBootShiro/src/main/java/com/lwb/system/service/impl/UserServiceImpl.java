package com.lwb.system.service.impl;

import com.lwb.system.dao.UserDao;
import com.lwb.system.domain.UserDO;
import com.lwb.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userMapper;


    @Override
    public UserDO get(Long id) {
        return null;
    }

    @Override
    public List<UserDO> list(Map<String, Object> map) {
        return userMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return 0;
    }

    @Override
    public int save(UserDO user) {
        return 0;
    }

    @Override
    public int update(UserDO user) {
        return 0;
    }

    @Override
    public int remove(Long userId) {
        return 0;
    }

    @Override
    public int batchremove(Long[] userIds) {
        return 0;
    }

    @Override
    public boolean exit(Map<String, Object> params) {
        return false;
    }

    @Override
    public Set<String> listRoles(Long userId) {
        return null;
    }

    @Override
    public int updatePersonal(UserDO userDO) {
        return 0;
    }

    @Override
    public Map<String, Object> updatePersonalImg(MultipartFile file, String avatar_data, Long userId) throws Exception {
        return null;
    }
}
