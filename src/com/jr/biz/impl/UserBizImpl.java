package com.jr.biz.impl;

import com.jr.biz.IUserBiz;
import com.jr.dao.impl.UserDaoImpl;
import com.jr.entry.User;

import java.util.List;

public class UserBizImpl implements IUserBiz {
    UserDaoImpl udi=new UserDaoImpl();
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
        return udi.deleteUser(user)==1?true:false;
    }

    @Override
    public List<User> queryByid(User user) {
        return null;
    }

    @Override
    public boolean changeUser(User user) {
        return false;
    }
}
