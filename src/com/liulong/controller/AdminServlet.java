package com.liulong.controller;

import com.liulong.entry.Admin;
import com.liulong.entry.Borrow;
import com.liulong.service.BookService;
import com.liulong.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private BookService bookService=new BookServiceImpl ();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method=req.getParameter ("method");
        if(method==null){
            method="findAll";
        }
        switch(method){
            case "findAll":
                String pageStr=req.getParameter ("page");
                Integer page=Integer.parseInt(pageStr);
                List<Borrow>listBorrows=bookService.findAllByState(0,page);
                req.setAttribute ("currentPage",page);
                req.setAttribute ("pages",bookService.getBorrowPagesByState(0));
                req.setAttribute ("dataPrePage",6);
                req.setAttribute ("list",listBorrows);
                req.getRequestDispatcher ("admin.jsp").forward (req,resp);
                break;
            case "handle":
//                <td>
//						<a href="/admin?method=handle&id=${borrow.id}&state=1">同意</a>
//						<a href="/admin?method=handle&id=${borrow.id}&state=2">拒绝</a>
//					</td>
                String idStr=req.getParameter ("id");
                String stateStr=req.getParameter ("state");
                Integer id=Integer.parseInt (idStr);
                Integer state=Integer.parseInt (stateStr);
                HttpSession session=req.getSession();
                Admin admin=(Admin)session.getAttribute ("admin");
                Integer adminid=admin.getId ();
                bookService.updateBorrowByBorrowId(adminid,id,state);
                resp.sendRedirect ("/admin?page=1");
                break;
            case "getBorrowed":
                stateStr=req.getParameter ("state");
                if(stateStr==null){
                    pageStr=req.getParameter ("page");
                    page=Integer.parseInt(pageStr);
                    listBorrows=bookService.findAllByState(1,page);
                    req.setAttribute ("currentPage",page);
                    req.setAttribute ("pages",bookService.getBorrowPagesByState(1));
                    req.setAttribute ("dataPrePage",6);
                    req.setAttribute ("list",listBorrows);
                    req.getRequestDispatcher ("return.jsp").forward (req,resp);
                }else{
                    idStr=req.getParameter ("id");
                    id=Integer.parseInt (idStr);
                    state=Integer.parseInt (stateStr);
                    if(state==3){
                        session=req.getSession();
                        admin=(Admin)session.getAttribute ("admin");
                        adminid=admin.getId ();
                        bookService.updateBorrowByBorrowId(adminid,id,state);
                        resp.sendRedirect ("/admin?method=getBorrowed&page=1");
                    }
                }






                break;
        }

    }
}
