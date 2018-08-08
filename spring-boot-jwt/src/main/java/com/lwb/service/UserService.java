package com.lwb.service;


import com.lwb.entity.UserBean;
import org.springframework.stereotype.Component;



@Component
public class UserService {

    public UserBean getUser(String username) {
        // 没有此用户直接返回null
//        if (! DataSource.getData().containsKey(username))
//            return null;

        UserBean user = new UserBean();
//        Map<String, String> detail = DataSource.getData().get(username);

        user.setUsername(username);
        user.setPassword("123");
        user.setRole("role");
        user.setPermission("permission");
        return user;
    }


}
