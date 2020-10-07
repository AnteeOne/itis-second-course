package ru.kpfu.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.Filter;

//@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        String isAgree = req.getParameter("agreement");

        RegistrationValidator validator = new RegistrationValidator(name,email,password,password2,isAgree);

        if(validator.isValidate()){
            User user = new User(name,email,password);
            FileSerializer serializer = new FileSerializer(user);
            serializer.writeInCSV();
        }
        resp.sendRedirect(req.getRequestURI());

    }

}
