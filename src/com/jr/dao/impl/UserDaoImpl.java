package com.jr.dao.impl;

import com.jr.dao.IUserDao;
import com.jr.entry.User;
import com.jr.util.DBHelper;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements IUserDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public int insertUser(User user) {
        return 0;
    }

    @Override
    public User selectUser(User user) {
        User user1=null;
        //连接数据库
        try {
            con = DBHelper.getconn();
            //获取Parpareparement
            String sql="select * from emp where name=? and password=?";
            ps = con.prepareStatement(sql);
            //设置值
            ps.setObject(1,user.getName());
            ps.setObject(2,user.getPassword());
            //执行查询操作
            rs=ps.executeQuery();
            if (rs.next()) {
                user1 = new User();
                user1.setName(rs.getString(2));
                user1.setPassword(rs.getString(3));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBHelper.closeAll(rs,ps,con);
        }
        return user1;
    }

    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
    public int deleteUser(User user) {
        return 0;
    }

    @Override
    public List<User> selectById(User user) {
        return null;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    public  int  upd(String sql,Object ...objs){
            int num = 0;
            try {
                con = DBHelper.getconn();
                ps = con.prepareStatement(sql);
                for (int i = 0; i<objs.length ; i++){
                    ps.setObject(i+1,objs[i]);
                }
                num = ps.executeUpdate();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }finally {
                DBHelper.closeAll(rs,ps,con);
            }
            return num;
        }
}
