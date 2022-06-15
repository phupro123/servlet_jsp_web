package com.motor.controller.web;

import com.motor.model.Category;
import com.motor.model.Product;
import com.motor.model.User;
import com.motor.service.*;
import com.motor.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/home/search"})
public class SearchController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IProductService productService = new ProductServiceImpl();
    IOrderService orderService = new OrderServiceImpl();
    ICategoryService categoryService = new CategoryServiceImpl();
    IBrandService brandService = new BrandServiceImpl();
    IUserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // thiết lập tiếng Việt
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");


        String txt1 = req.getParameter("txt");
        String csrf = req.getParameter("_csrf");

        HttpSession session = req.getSession();
        String csrf_cookie = (String) session.getAttribute("_csrf");

        User user = (User) session.getAttribute("loginedUser");

        // Nếu giống nhau thì mới được phép thực thi
        if(csrf.equals(csrf_cookie))
        {
            List<Category> listCate= categoryService.findAll();

            List<Product> list3 = productService.getTop3Product();
            List<Product> listS = productService.searchByProductName(txt1);
            req.setAttribute("list3", list3);
            req.setAttribute("txtS", txt1);
            req.setAttribute("listAll", listS);
            req.setAttribute("AllCate",listCate);


            req.getRequestDispatcher("/views/web/search.jsp").forward(req, resp);

        }
        else{
            req.getRequestDispatcher("/common/decorators/error.jsp").forward(req, resp);
        }





    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}

