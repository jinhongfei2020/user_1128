package com.jr.biz;

import com.jr.entry.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IUserBiz {

    //注册
    public boolean registerUser(User user);

    //登录
    public boolean loginUser(User user);

    //展示表单
    public List<User> queryAll();

    //删除员工
    public boolean removeUser(User user);

    //修改员工信息
    public User queryByid(int uid);
    public boolean changeUser(User user);



}
