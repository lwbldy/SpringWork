package com.lwb.system.controller;

import com.lwb.common.util.MD5Utils;
import com.lwb.common.util.R;
import com.lwb.common.util.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {


    @RequestMapping("/login")
    @ResponseBody
    R ajaxLogin(String username, String password) {
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return R.ok();
        } catch (AuthenticationException e) {
            return R.error("用户或密码错误");
        }
    }

    @GetMapping("/nologing")
    @ResponseBody
    R nologing(){
        return R.error("没有登录nologin");
    }

    @GetMapping("/isloging")
    @ResponseBody
    R isloging(){
        return R.error("登录成功");
    }

    @GetMapping("/logout")
    @ResponseBody
    R logout() {
        ShiroUtils.logout();
        return R.ok("退出成功");
    }


    @RequiresPermissions("hasRols")
    @GetMapping("/hasRols")
    @ResponseBody
    R hasRole(){
        return R.ok("有权限");
    }


    @RequiresPermissions("noHasRole")
    @GetMapping("/noHasRole")
    @ResponseBody
    R noHasRole(){
        return R.ok("有权限");
    }


    @GetMapping("/rowhtml")
    String noneHtml(){
        return "hasRows";
    }

}
