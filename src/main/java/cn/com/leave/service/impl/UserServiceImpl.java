package cn.com.leave.service.impl;

import cn.com.leave.dao.UserDao;
import cn.com.leave.entity.User;
import cn.com.leave.service.UserService;

import javax.annotation.Resource;

/**
 * Created by chenlu on 2016/2/1.
 */
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;
    public User login(String username, String password) {
        return userDao.login(username,password);
    }
}
