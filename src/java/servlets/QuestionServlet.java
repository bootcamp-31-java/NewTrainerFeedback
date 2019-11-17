/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.impl.CategoryController;
import controllers.impl.QuestionController;
import daos.IGeneralDAO;
import daos.impl.GeneralDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Array;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AnswerEssay;
import models.AnswerPg;
import models.Category;
import models.Form;
import models.Question;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author G551VW
 */
public class QuestionServlet extends HttpServlet {

    HttpSession httpSession = null;
    IGeneralDAO igd = null;
    SessionFactory factory = HibernateUtil.getSessionFactory();
    private QuestionController questc = new QuestionController(HibernateUtil.getSessionFactory());
    private CategoryController categoryc = new CategoryController(HibernateUtil.getSessionFactory());


    public QuestionServlet() {
        factory = HibernateUtil.getSessionFactory();
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
            request.getSession().setAttribute("questions", questc.getAll());
            request.getSession().setAttribute("categorys", categoryc.getAll());

            response.sendRedirect("fillform.jsp");
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String[] points = new String[8];
        String[] notes = new String[8];
        String[] qids = new String[8];
        String[] detail = new String[4];
        String[] qide = new String[4];

        for (int i = 0; i < 8; i++) {
            points[i] = request.getParameter("point[" + i + "]");
            notes[i] = request.getParameter("note[" + i + "]");
            qids[i] = request.getParameter("qid[" + i + "]");

//            igd.insertUpdateDelete(new AnswerPg(new BigDecimal(0), new BigInteger(points[i]), notes[i], new Form(new BigDecimal(1)), new Question(new BigDecimal(qids[i]))), false);
//            System.out.println(points[i] + "-" + notes[i] + "=" + qids[i]);

        }
        for (int j = 0; j < 3; j++) {
            qide[j] = request.getParameter("qide[" + j + "]");
            detail[j] = request.getParameter("detail[" + j + "]");
//            igd.insertUpdateDelete(new AnswerEssay(new BigDecimal(0), detail[j], new Form(new BigDecimal(1)), new Question(new BigDecimal(qide[j]))), false);
//            System.out.println(qide[j]+" - "+detail[j]);

        }

//        String[] points = (String[]) request.getAttribute("point[]");
//        for (int i = 0; i < points.length; i++) {
//
//            System.out.println(points[i]);
//
//        }
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
