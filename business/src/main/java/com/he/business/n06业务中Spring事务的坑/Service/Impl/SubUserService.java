package com.he.business.n06业务中Spring事务的坑.Service.Impl;


import com.he.business.n06业务中Spring事务的坑.Service.UserRepository;
import com.he.business.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class SubUserService {


    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void subCreateUser(){
        log.error("### 创建子用户");
        userRepository.save(new User("hening sub"));
        throw new RuntimeException("invalid status");
    }

}
