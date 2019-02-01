package com.ti.crowd_manager.service.impl;

import com.ti.crowd_manager.domain.User;
import com.ti.crowd_manager.domain.UserExample;
import com.ti.crowd_manager.mapper.UserMapper;
import com.ti.crowd_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Ti
 * @date 2019/2/1
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public User findByName(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(user.getName());
        List<User> userList = mapper.selectByExample(example);
        if (userList != null && userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }

    @Transactional
    @Override
    public Integer addUser(User user) {
        User user1 = findByName(user);
        if (user1 == null) {
            int insert = mapper.insert(user);
            return insert;
        } else {
            return 0;
        }
    }

    @Override
    public User login(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(user.getName())
                .andPasswordEqualTo(user.getPassword());
        List<User> userList = mapper.selectByExample(example);
        if (userList != null && userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }
}
