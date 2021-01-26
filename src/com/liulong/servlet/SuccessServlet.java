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

@WebServlet("/success")
public class SuccessServlet extends HttpServlet {

    UserRepository userRepository=new UserRepository();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type=req.getParameter("type");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        switch (type){
            case "adduser":
                //处理添加请求
                User user=new User(name,password);
                userRepository.add (user);
                break;
            case "deleteuser":
                break;
            case "updateuser":
                String strId=req.getParameter ("id");
                int id=Integer.parseInt (strId);
                userRepository.update (id,name,password);
                break;
        }

        List<User> list=userRepository.findAll ();
        req.setAttribute ("users",list);
        req.getRequestDispatcher ("success.jsp").forward (req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type=req.getParameter("type");
        switch (type){
            case "add":
                resp.sendRedirect ("add.jsp");
                break;
            case "delete":
                String strId=req.getParameter ("id");
                int id=Integer.parseInt (strId);
                userRepository.delete(id);
                List<User> list=userRepository.findAll ();
                req.setAttribute ("users",list);
                req.getRequestDispatcher ("success.jsp").forward (req,resp);
                break;
            case "update":
                String strId2=req.getParameter ("id");
                int id2=Integer.parseInt (strId2);
                User user=userRepository.findById (id2);
                req.setAttribute ("user",user);
                req.getRequestDispatcher ("update.jsp").forward(req, resp);
                break;
        }

    }
}
