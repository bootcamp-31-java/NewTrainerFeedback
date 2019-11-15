/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.impl;

import daos.IGeneralDAO;
import daos.impl.GeneralDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Status;
import org.hibernate.SessionFactory;

/**
 *
 * @author Aseprudin
 */
public class StatusController {
    private SessionFactory factory;
    private IGeneralDAO<Status> istatusdao;

    public StatusController(SessionFactory factory) {
        istatusdao = new GeneralDAO<>(factory, Status.class);
    }
    
    public String save(String id, String name){
        if (istatusdao.saveOrDelete(new Status(new BigDecimal(id), name), true)) {
            return "Saved Success";
        } else {
            return "Save Failed";
        }
    }
    
    public String delete(String id){
        if (istatusdao.saveOrDelete(new Status(new BigDecimal(id)), false)){
            return "Delete Success";
        } else {
            return "Delete Failed";
        }
    }
    
    public List<Status> getAll(){
        return istatusdao.getAll();
    }
    
    public Status getById(String id){
        return istatusdao.getByid(new BigDecimal(id));
    }
    
}
