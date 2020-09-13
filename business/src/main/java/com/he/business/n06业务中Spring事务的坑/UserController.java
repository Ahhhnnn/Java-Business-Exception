package com.he.business.n06业务中Spring事务的坑;

import com.he.business.n06业务中Spring事务的坑.Service.Impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save1")
    public Object save1(){
        try {
            userService.createUserWrong1("hening main");
        } catch (Exception e) {
            log.error("###error{}",e.getMessage());
        }
        return "success";
    }

    @RequestMapping("/save2")
    public Object save2() throws IOException {
        userService.createUserWrong2("hening2");
        return "success";
    }

}
