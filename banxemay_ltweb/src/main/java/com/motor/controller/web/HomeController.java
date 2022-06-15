package com.motor.controller.web;

import com.motor.model.Category;
import com.motor.model.Product;
import com.motor.model.User;
import com.motor.service.ICategoryService;
import com.motor.service.IOrderService;
import com.motor.service.IProductService;
import com.motor.service.impl.CategoryServiceImpl;
import com.motor.service.impl.OrderServiceImpl;
import com.motor.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IProductService productService = new ProductServiceImpl();
    IOrderService orderService = new OrderServiceImpl();
    ICategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // thiết lập tiếng Việt
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        String csrf = UUID.randomUUID().toString();
        session.setAttribute("_csrf", csrf);


        User user = (User) session.getAttribute("loginedUser");

        List<Category> listCate= categoryService.findAll();
        List<Product> listTopProducts = productService.findAll();
        req.setAttribute("Topproducts", listTopProducts);
        req.setAttribute("AllCate",listCate);

        req.getRequestDispatcher("/views/web/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}

