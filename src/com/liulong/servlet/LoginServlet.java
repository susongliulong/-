package com.liulong.servlet;

import com.liulong.entry.User;
import com.liulong.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        UserRepository repository=new UserRepository();
        List<User> list= repository.findAll ();
        if(list==null){
            resp.sendRedirect ("register.jsp");
        }else{
            for(User user:list){
                if(user.getName ().equals (name)&&user.getPassword().equals(password)){
                    req.setAttribute ("users",list);
                    req.getRequestDispatcher ("success.jsp").forward (req, resp);
                    return;
                }
            }
            String falseMessage="当前，用户没有注册，请先完成注册";
            req.setAttribute ("falseMessage",falseMessage);
            req.getRequestDispatcher ("false.jsp").forward (req,resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
