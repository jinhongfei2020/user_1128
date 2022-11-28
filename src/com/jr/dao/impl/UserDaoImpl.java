package com.jr.dao.impl;

import com.jr.dao.IUserDao;
import com.jr.entry.User;
import com.jr.util.DBHelper;

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
