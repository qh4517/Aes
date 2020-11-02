package com.qh.web;


import com.qh.Aes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @ResponseBody
    @RequestMapping(value = "/login")
    public String login(String loginName, String loginPwd){
        System.out.println(loginName);
        System.out.println(loginPwd);


        try {
            // AES解码用户名和密码
            loginName = Aes.aesDecrypt(loginName);
            loginPwd = Aes.aesDecrypt(loginPwd);

        } catch (Exception e1) {
//            loginName = "";
//            loginPwd = "";
            e1.printStackTrace();
           // log.error(e1);
        }

        loginName = loginName.trim();
        loginPwd = loginPwd.trim();
        System.out.println(loginName);
        System.out.println(loginPwd);
        return "success";
    }

}
