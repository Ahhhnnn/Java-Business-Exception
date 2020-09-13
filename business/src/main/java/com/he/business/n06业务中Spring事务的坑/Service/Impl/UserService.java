package com.he.business.n06业务中Spring事务的坑.Service.Impl;


import com.he.business.n06业务中Spring事务的坑.Service.UserRepository;
import com.he.business.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubUserService subUserService;


    @Transactional
    public void createUserWrong1(String name) {
        createMainUser(name);
        try {
            subUserService.subCreateUser();
        } catch (Exception e) {
            log.error("### SubCreate Error {}",e.getMessage());
        }
    }

    private void createMainUser(String name){
        userRepository.save(new User(name));
    }



    //即使出了受检异常也无法让事务回滚
    @Transactional(rollbackOn = Exception.class)
    public void createUserWrong2(String name) throws IOException {
        userRepository.save(new User(name));
        otherTask();
    }

    //因为文件不存在，一定会抛出一个IOException
    private void otherTask() throws IOException {
        Files.readAllLines(Paths.get("file-that-not-exist"));
    }
}
