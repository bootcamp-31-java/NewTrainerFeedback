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
import models.Employee;
import models.Trainer;
import org.hibernate.SessionFactory;

/**
 *
 * @author Aseprudin
 */
public class TrainerController {
    private SessionFactory factory;
    private IGeneralDAO<Trainer> itrainerdao;

    public TrainerController(SessionFactory factory) {
        itrainerdao = new GeneralDAO<>(factory, Trainer.class);
    }
    
    public String save(String id, String employee){
        if (itrainerdao.saveOrDelete(new Trainer(new Integer(id), new Employee(new Integer(id))), true)) {
            return "Save Success";
        } else {
            return "Save Failed";
        }
    }
    
    public String delete (String id){
        if (itrainerdao.saveOrDelete(new Trainer(new Integer(id)), false)) {
            return "Delete SUcces";
        } else {
            return "Delete failed";
        }
    }
    
    public List<Trainer> getAll(){
        return itrainerdao.getAll();
    }
    
    public Trainer getById(String id){
        return itrainerdao.getByid(new BigDecimal(id));
    }
}
