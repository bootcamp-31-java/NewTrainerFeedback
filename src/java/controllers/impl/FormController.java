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
import models.Form;
import models.Shcedule;
import org.hibernate.SessionFactory;

/**
 *
 * @author Aseprudin
 */
public class FormController {
    private SessionFactory factory;
    private IGeneralDAO<Form> iformdao;

    public FormController(SessionFactory factory) {
        iformdao = new GeneralDAO<>(factory, Form.class);
    }
    
    public String save(String id, String schedule, String participant){
        if (iformdao.saveOrDelete(new Form(new BigDecimal(id), new Employee(new Integer(id)), new Shcedule(id)), true)) {
            return "Save Success";
        } else {
            return "SAve Failed";
        }
    }
    
    public String delete(String id){
        if (iformdao.saveOrDelete(new Form(new BigDecimal(id)), false)) {
            return "Delete Success";
        } else {
            return "Delete Failed";
        }
    }
    
    public List<Form> getAll(){
        return iformdao.getAll();
    }
    
    public Form getById(String id){
        return iformdao.getByid(new BigDecimal(id));
    }
}
