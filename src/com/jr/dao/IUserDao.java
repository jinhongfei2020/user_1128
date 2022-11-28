package com.jr.dao;

import com.jr.entry.User;

import java.util.List;

public interface IUserDao {


    //注册
    public int insertUser(User user);

    //登录
    public User selectUser(User user);


    //展示表单 查询方法
    public List<User> selectAll();

    //删除用户 删除方法
    public int deleteUser(User user);

    //修改用户信息 修改方法
    public User selectById(int uid);
    public int updateUser(User user);
}
