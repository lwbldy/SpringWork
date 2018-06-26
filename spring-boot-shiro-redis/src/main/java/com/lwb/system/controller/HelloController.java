package com.lwb.system.controller;

import com.lwb.common.util.R;
import com.lwb.system.domain.UserDO;
import com.lwb.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class HelloController {

    @Autowired
    UserService userService;

    @RequestMapping("/testEhcache")
    @ResponseBody
    UserDO ajaxLogin(long id) {
        return userService.get(id);
    }


    @ResponseBody
    @RequestMapping("/delEhcache")
    R delEhcache(long id){
        userService.modifyUser(id);
        return R.ok("删除成功");
    }


    /**
     * 测试 共享session
     * @param session
     * @return
     */
    @RequestMapping("/uid")
    @ResponseBody
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

}
