/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.IAvgDAO;
import daos.IGeneralDAO;
import daos.impl.AvgDAO;
import daos.impl.GeneralDAO;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import models.AnswerPg;
import models.Category;
import models.Employee;
import models.Job;
import models.Materi;
import models.Role;
import models.Room;
import models.Shcedule;
import org.hibernate.SessionFactory;

/**
 *
 * @author Aseprudin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        SessionFactory factory = HibernateUtil.getSessionFactory();

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyy");
        String startDate = dateFormat.format(date);

        System.out.println(factory);

//        IGeneralDAO<Role> iroledao = new GeneralDAO<>(factory, Role.class);
//        if (iroledao.saveOrDelete(new Role(new Integer(1), "Koko"), true)) {
//            System.out.println("sukses");
//        } else {
//            System.out.println("gagal");
//        }
//        
        IGeneralDAO<Shcedule> igdao = new GeneralDAO<>(factory, Shcedule.class);
//        if (igdao.saveOrDelete(new Shcedule("2", new Date("12/12/2012"), new Date("12/12/2012"), new Employee(new Integer(1)), new Materi(new BigDecimal(1)), new Room(new BigDecimal(1))), true)) {
//            System.out.println("BB");
//        } else {
//            System.out.println("A");
//        }
//        IGeneralDAO<Category> iGeneralDAO = new GeneralDAO<>(factory, Category.class);
        IGeneralDAO igd = new GeneralDAO(HibernateUtil.getSessionFactory());
//        if (igdao.saveOrDelete(new Shcedule("SCH0009", new Date("10:00 12/12/2012"), new Employee(new Integer(1)), new Materi(new BigDecimal(1)), new Room(new BigDecimal(3))), true)) {
//            System.out.println("SUkses");
//        } else {
//            System.out.println("gagal");
//        }
//        IGeneralDAO<Category> iGeneralDAO = new GeneralDAO<>(factory, Category.class);
//        IGeneralDAO igd = new GeneralDAO(HibernateUtil.getSessionFactory());
//        
//        igd.saveOrDelete(new Role(new Integer(2), "Alo"), true);
//        for (Category category : iGeneralDAO.getAll()) {
//            System.out.println(category.getName());
//        }

//        IAvgDAO ivg = new AvgDAO(HibernateUtil.getSessionFactory());
//        
//        for (Object answerPg : ivg.avgData()) {
//            
//            System.out.println(answerPg);
//        }

       SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyy");
        String df = sdf.format(new Date());
        String id = "SCH"+df+String.format("%04d", igdao.countData(new Shcedule()));
        System.out.println(id);

    }

}
