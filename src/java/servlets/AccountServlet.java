/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import daos.IGeneralDAO;
import daos.impl.GeneralDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Account;
import models.Employee;
import models.EmployeeRole;
import org.hibernate.SessionFactory;
import tools.BCrypt;
import tools.HibernateUtil;

/**
 *
 * @author G551VW
 */
public class AccountServlet extends HttpServlet {

    HttpSession ses = null;
    private SessionFactory factory;
    IGeneralDAO igd = null;
    String username = null;
    String password = null;
    String button = null;

    public AccountServlet() {
        factory = HibernateUtil.getSessionFactory();//koneksi hibernate
        igd = new GeneralDAO(factory);
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @pararesponse
     * @throws ServletExceptionm request servlet request
     * @param response servlet if a servlet-specific error occurs
     * @throws IOException if an I/O error hrows ServletExceptionm request
     * servlet request
     * @param response servlet if a servlet-specific error occurs
     * @throws IOException if an I/O eoccurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ses = request.getSession(true);
        button = request.getParameter("button");
        username = request.getParameter("username");
        password = request.getParameter("password");
        Employee emp = (Employee) igd.getUser(new Employee(), "email", username);
        EmployeeRole empr = (EmployeeRole) igd.getUserById(new EmployeeRole().getClass(), emp.getId());
        Account account = (Account) igd.getUserById(new Account().getClass(), emp.getId());
        System.out.println(password);
        if (BCrypt.checkpw(password, account.getPassword())) {

            ses.setAttribute("user", account);
            ses.setAttribute("employee", emp);
            if (empr.getRole().getName().equals("ADMIN")) {
                response.sendRedirect("dashboardAdmin.jsp");
            }
            if (empr.getRole().getName().equals("PARTICIPANT")) {
                response.sendRedirect("dashboardParticipant.jsp");
            }
            if (empr.getRole().getName().equals("TRAINER")) {
                response.sendRedirect("dashboardTrainer.jsp");
            }

        } else {
            response.sendRedirect("login.jsp");
        }
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}