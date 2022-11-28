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
    }
    public void showUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

    }

    public void removeUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }

    public void selectByid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String uid = request.getParameter("uid");

        UserBizImpl userBiz = new UserBizImpl();

        User user = userBiz.queryByid(Integer.parseInt(uid));

        request.setAttribute("user",user);
        request.getRequestDispatcher("update.jsp").forward(request,response);

    }
    public void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, ParseException,IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String uid = request.getParameter("uid");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String age = request.getParameter("age");

        User user = new User();

        user.setUid(Integer.parseInt(uid));
        user.setName(name);
        user.setPassword(password);
        user.setAge(Integer.parseInt(age));

        UserBizImpl userBiz = new UserBizImpl();

        boolean bl = userBiz.changeUser(user);

        if (bl){
            System.out.println("成功");
            response.sendRedirect("user?i=1");
        }else {
            System.out.println("失败");
            request.getRequestDispatcher("update.jsp").forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
