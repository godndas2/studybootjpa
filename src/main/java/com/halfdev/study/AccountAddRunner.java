package com.halfdev.study;

import com.halfdev.study.domain.model.Account;
import com.halfdev.study.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountAddRunner implements ApplicationRunner {

    @Autowired
    AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account halfdev = accountService.createAccount("halfdev", "1234");
        System.out.println("username :" + halfdev.getUserName() + " " + "password : " + halfdev.getPassword());
    }
}
