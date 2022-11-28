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
        int num= Integer.parseInt(request.getParameter("num"));
        switch (num){
            case 1:
                login(request,response);
                break;
        }

    }
    public void Register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
    }
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        //查询功能
        UserBizImpl biz = new UserBizImpl();
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        boolean e = biz.loginUser(user);
        if(e){
            response.getWriter().println("登录成功");
           /* request.getRequestDispatcher("rs?i=3").forward(request,response);*/
        }else{
            response.getWriter().println("<a style='text-decoration:none;color:pink;' href='index.jsp'><h1 >登录失败,请点击此链接重新登录</h1></a>");

        }

    }
    public void showUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

    }

    public void removeUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

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
