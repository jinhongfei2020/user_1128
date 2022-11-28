package com.jr.service;

import com.jr.biz.impl.UserBizImpl;
import com.jr.entry.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");


        Register(request,response);

    }
    public void Register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        int uid = Integer.parseInt(request.getParameter("uid"));
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        int age = Integer.parseInt(request.getParameter("age"));

        UserBizImpl ubi = new UserBizImpl();
        User user = new User(uid,name,password,age);
        boolean bool = ubi.registerUser(user);

        if (bool){
            System.out.println("注册成功");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else {
            System.out.println("注册失败");
            response.getWriter().println("<h1 color:pink;>注册失败</h1>"+"<a href='insert.jsp'>register again</a>");
        }
    }
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
    }
    public void showUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

    }

    public void removeUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            UserBizImpl ubi=new UserBizImpl();
            User user=new User();
            user.setUid(Integer.parseInt(request.getParameter("empno")));
            boolean boo=ubi.removeUser(user);
            if (boo){
                showUser(request,response);
            }else{
                showUser(request,response);
            }

    }
    public void selectByid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, ParseException,IOException {

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
