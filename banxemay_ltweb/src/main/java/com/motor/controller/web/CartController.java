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


@WebServlet(urlPatterns = {"/home/cart"})
public class CartController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IProductService productService = new ProductServiceImpl();
    IOrderService orderService = new OrderServiceImpl();
    ICategoryService categoryService = new CategoryServiceImpl();
    IBrandService brandService = new BrandServiceImpl();
    IUserService userService = new UserServiceImpl();
    ICartItemsService cartItemsService = new CartItemsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // thiết lập tiếng Việt
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");


        String txt1 = req.getParameter("txt");


        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("loginedUser");



        List<Category> listCate= categoryService.findAll();

        List<Product> list3 = productService.getTop3Product();
        List<Product> listS = productService.searchByProductName(txt1);
        req.setAttribute("list3", list3);
        req.setAttribute("txtS", txt1);
        req.setAttribute("listAll", listS);
        req.setAttribute("AllCate",listCate);


        req.getRequestDispatcher("/views/web/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}

