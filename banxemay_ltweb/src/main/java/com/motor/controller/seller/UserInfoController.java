package com.motor.controller.seller;

import com.motor.model.User;
import com.motor.service.IUserService;
import com.motor.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.apache.commons.text.StringEscapeUtils.escapeHtml4;

@WebServlet("/seller/userinfo")
public class UserInfoController extends HttpServlet {
    IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // thiết lập tiếng Việt
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("loginedUser");

        int id = Integer.parseInt(req.getParameter("id"));
        if (user.getId() == id) {
            User userInfo = userService.findOne(id);
            req.setAttribute("user", userInfo);
            req.getRequestDispatcher("/views/seller/userinfo.jsp").forward(req, resp);
            req.setAttribute("active", 6);
        } else
            resp.sendRedirect("/error");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // thiết lập tiếng Việt
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("loginedUser");
        int id = user.getId();

        String action = req.getParameter("action");
        switch (action) {
            case "info": {
                String phone = escapeHtml4(req.getParameter("phone"));
                String email = escapeHtml4(req.getParameter("email"));
                String fullname = escapeHtml4(req.getParameter("fullname"));
                User newUser = new User();
                newUser.setId(id);
                newUser.setPhone(phone);
                newUser.setMail(email);
                newUser.setfullname(fullname);
                userService.updateInfo(newUser);

                break;
            }
            case "image": {
                String image = req.getParameter("image");
                User newUser = new User();
                newUser.setId(id);
                newUser.setImage(image);
                userService.updateImage(newUser);
                break;
            }
            case "password":
                String oldPassword = req.getParameter("oldPassword");
                String password = req.getParameter("password");
                if (oldPassword.equals(user.getPassword())) {
                    User newUser = new User();
                    newUser.setId(id);
                    newUser.setPassword(password);
                    userService.updatePassword(newUser);
                } else {
                    resp.sendRedirect("/error");
                    return;
                }
                break;
            default:
                resp.sendRedirect("userinfo?id=" + id);
                break;
        }
        resp.sendRedirect("/logout");
    }
}
