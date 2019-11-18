/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.impl.MateriController;
import controllers.impl.RoomController;
import controllers.impl.ScheduleController;
import controllers.impl.TrainerController;
import daos.IGeneralDAO;
import daos.impl.GeneralDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Shcedule;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Aseprudin
 */
@WebServlet(name = "ScheduleServlet", urlPatterns = {"/scheduleservlet"})
public class ScheduleServlet extends HttpServlet {

    IGeneralDAO igdao = null;
    SessionFactory factory = HibernateUtil.getSessionFactory();
    private ScheduleController schedulec = new ScheduleController(HibernateUtil.getSessionFactory());
    private RoomController roomc = new RoomController(HibernateUtil.getSessionFactory());
    private TrainerController trainerc = new TrainerController(HibernateUtil.getSessionFactory());
    private MateriController materic = new MateriController(HibernateUtil.getSessionFactory());

    public ScheduleServlet() {
        igdao = new GeneralDAO(factory);
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
            request.getSession().setAttribute("shcedules", schedulec.getAll());
            request.getSession().setAttribute("trainers", trainerc.getAll());
            request.getSession().setAttribute("rooms", roomc.getAll());
            request.getSession().setAttribute("materis", materic.getAll());
            request.getSession().setAttribute("historySchedule", igdao.historyDate(new Shcedule()));
            response.sendRedirect("schedule.jsp");
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
        String room = request.getParameter("room");
        String trainer = request.getParameter("trainer");
        String materi = request.getParameter("materi");
        String eventDate = request.getParameter("eventDate");
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyy");
        String df = sdf.format(new Date());
        String id = "SCH"+df+String.format("%04d", igdao.countData(new Shcedule()));
        
        
//        System.out.println(id);
        schedulec.saveDate(id, eventDate, trainer, room, materi);

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
