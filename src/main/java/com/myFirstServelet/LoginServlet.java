package com.myFirstServelet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = { "/LoginServlet" }

)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doPost(request, response);

        //get requset parameter for userId Password


        String user = request.getParameter("user");
        String pwd =request.getParameter("pwd");

        Validator validator = new Validator();
        boolean userNameCheck = validator.validateUserName(user);
        boolean passwordCheck = validator.validatePassword(pwd);


        String userId = getServletConfig().getInitParameter("user");
        String password=getServletConfig().getInitParameter("pwd");




        if (userNameCheck==true && passwordCheck==true){
            request.setAttribute("user",user);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request,response);
        }

        else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Login.html");
            PrintWriter out =response.getWriter();
            out.println("<font color=red>Either username or password is incorrect</font>");
            requestDispatcher.include(request,response);
        }

    }
}
