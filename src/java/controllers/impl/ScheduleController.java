/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.impl;

import daos.IGeneralDAO;
import daos.impl.GeneralDAO;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import models.Employee;
import models.Materi;
import models.Room;
import models.Shcedule;
import models.Trainer;
import org.hibernate.SessionFactory;

/**
 *
 * @author Aseprudin
 */
public class ScheduleController {
    private SessionFactory factory;
    private IGeneralDAO<Shcedule> ischeduledao;
    

    public ScheduleController(SessionFactory factory) {
        ischeduledao = new GeneralDAO<>(factory, Shcedule.class);
    }
    
    public String save(String id, String eventDate, String expiredDate, String trainer, String room, String title){
        if (ischeduledao.saveOrDelete(new Shcedule(id, new Date(eventDate), new Date(expiredDate), new Employee(new Integer(trainer)), new Materi(new BigDecimal(title)), new Room(new BigDecimal(room))), true)) {
            return "Save Success";
        } else {
            return "Save Failed";
        }
    }
    
    public String delete(String id){
        if (ischeduledao.saveOrDelete(new Shcedule(id), false)) {
            return "delete Success";
        } else {
            return "delete failed";
        }
    }
    
    public List<Shcedule> getAll(){
        return ischeduledao.getAll();
    }
    
    public Shcedule getById(String id){
        return ischeduledao.getByid(id);
    }
    
}
