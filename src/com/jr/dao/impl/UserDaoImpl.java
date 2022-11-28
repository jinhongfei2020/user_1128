package com.jr.dao.impl;

import com.jr.dao.IUserDao;
import com.jr.entry.User;
import com.jr.util.DBHelper;
import sun.applet.AppletResourceLoader;

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
        return null;
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
    public User selectById(int uid) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;

        try {
            conn = DBHelper.getconn();
            String sql = "select * from t_user where uid=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,uid);
            rs = ps.executeQuery();
            if (rs.next()){
                u = new User();
                u.setUid(rs.getInt("uid"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                u.setAge(rs.getInt("age"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,conn);
        }
        return u;
    }

    @Override
    public int updateUser(User user) {

        Connection conn = null;
        PreparedStatement ps = null;
        int x = 0;

        try {
            conn = DBHelper.getconn();
            String sql = "update t_user set name=?,password=?,age=? where uid=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
            ps.setInt(3,user.getAge());
            ps.setInt(4,user.getUid());
            x = ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,con);
        }
        return x;
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
