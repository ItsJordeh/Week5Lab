/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 *
 * @author User
 */
public class LoginServlet extends HttpServlet {
    
    private User user;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (request.getParameter("logout") != null) {
            
            session.invalidate();
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
            
        } else if (session.getAttribute("username") != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
                    .forward(request, response);
        } else {
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        AccountService service = new AccountService();
        
        this.user = new User(request.getParameter("username"), request.getParameter("password"));
        if (user.getUsername().equals("") && user.getPassword().equals("")) {
            
            request.setAttribute("error", "Please enter a username and password");
        } else {            
            user = service.login(request.getParameter("username"), request.getParameter("password"));
            
            if (user == null) {
                request.setAttribute("name", request.getParameter("username"));
                request.setAttribute("error", "Incorrect username or password");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                        .forward(request, response);
            } else {
                session.setAttribute("username", user.getUsername());
                getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
                        .forward(request, response);
            }
            
        }
        
    }
    
}
