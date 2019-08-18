package com.halfdev.study.service;

import com.halfdev.study.domain.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
