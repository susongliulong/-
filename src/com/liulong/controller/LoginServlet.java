package com.liulong.controller;

import com.liulong.entry.Admin;
import com.liulong.entry.Reader;
import com.liulong.rpository.BookRepository;
import com.liulong.service.BookService;
import com.liulong.service.LoginService;
import com.liulong.service.impl.BookServiceImpl;
import com.liulong.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.liulong.entry.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private LoginService loginService;
    private BookService bookService;

    /**
     * 处理登录请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        loginService=new LoginServiceImpl ();
        bookService=new BookServiceImpl ();
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        String type=req.getParameter("type");
        Object object=loginService.login (name,password,type);
        if(object==null){
            resp.sendRedirect ("/login.jsp");
        }else{
            HttpSession session=req.getSession ();
            switch (type){
                case "reader":
                    Reader reader=(Reader)object;
                    session.setAttribute ("reader",reader);
                    //跳转到读者页面
                    resp.sendRedirect ("/book?page=1");
                    break;
                case "admin":
                    Admin admin=(Admin)object;
                    session.setAttribute("admin",admin);
                    resp.sendRedirect("/admin?page=1");
                    break;
            }
        }

    }
}
