package com.jr.biz.impl;

import com.jr.biz.IUserBiz;
import com.jr.dao.impl.UserDaoImpl;
import com.jr.entry.User;

import java.util.List;

public class UserBizImpl implements IUserBiz {

    UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public boolean registerUser(User user) {
        return false;
    }

    @Override
    public boolean loginUser(User user) {
        return false;
    }

    @Override
    public List<User> queryAll() {
        return null;
    }

    @Override
    public boolean removeUser(User user) {
        return false;
    }

    @Override
    public User queryByid(int uid) {
        return userDao.selectById(uid);
    }

    @Override
    public boolean changeUser(User user) {
        return userDao.updateUser(user)==0?false:true;
    }
}
