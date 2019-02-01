package com.ti.crowd_manager.service;

import com.ti.crowd_manager.domain.User;

public interface UserService {
    User findByName(User user);

    Integer addUser(User user);

    User login(User user);
}
