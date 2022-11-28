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

        int i = 0;

        try {
            con = DBHelper.getconn();
            String sql = "insert into user values (?,?,?,?)";
            ps = con.prepareStatement(sql);
            i = upd(sql,user.getUid(),user.getName(),user.getPassword(),user.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,con);
        }
        return i;
    }

    @Override
    public User selectUser(User user) {
        User user2 =null;
        //连接数据库
        try {
            con = DBHelper.getconn();
            //获取Parpareparement
            String sql="select * from user where name=? and password=?";
            ps = con.prepareStatement(sql);
            //设置值
            ps.setObject(1,user.getName());
            ps.setObject(2,user.getPassword());
            //执行查询操作
            rs=ps.executeQuery();
            if (rs.next()) {
                user2 = new User();
                user2.setName(rs.getString(2));
                user2.setPassword(rs.getString(3));
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
        return user2;
    }

    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
    public int deleteUser(User user) {
        String sql="delete from team5 where uid=?";
        return upd(sql,user.getUid());
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
