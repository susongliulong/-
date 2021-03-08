package com.liulong.controller;

import com.liulong.service.BookService;
import com.liulong.service.impl.BookServiceImpl;
import com.liulong.entry.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/book")
public class BookServlet extends HttpServlet {

    private BookService bookService=new BookServiceImpl ();

    /**
     * 用来加载图书数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method=req.getParameter ("method");
        if(method==null){
            method="findAll";
        }
        HttpSession session=req.getSession ();
        Reader reader = (Reader)session.getAttribute ("reader");
        switch(method){
            case "findAll":
                String pageStr=req.getParameter ("page");
                Integer page=Integer.parseInt (pageStr);
                List<Book>list=bookService.findAll (page);
                req.setAttribute ("currentPage",page);
                req.setAttribute ("pages",bookService.getPages ());
                req.setAttribute ("dataPrePage",6);
                req.setAttribute ("list",list);
                req.getRequestDispatcher ("index.jsp").forward (req,resp);
                break;
            case "addBorrow":
                String bookidStr=req.getParameter("bookid");
                Integer bookid=Integer.parseInt(bookidStr);
                Integer readerid=reader.getId ();
                bookService.addBorrow (readerid,bookid);
                resp.sendRedirect ("/book?page=1");
                break;
            case "findAllBorrow":
                readerid=reader.getId ();
                pageStr=req.getParameter ("page");
                page=Integer.parseInt (pageStr);
                List<Borrow>borrowList=bookService.findAllByReaderId(readerid,page);
                req.setAttribute ("list",borrowList);
                req.setAttribute ("currentPage",page);
                int pages=bookService.getBorrowPages(readerid);
                req.setAttribute ("pages",pages);
                req.setAttribute ("dataPrePage",6);
                req.getRequestDispatcher ("borrow.jsp").forward (req,resp);
                break;
        }

    }
}
