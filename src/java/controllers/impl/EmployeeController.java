/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.impl;

import daos.IGeneralDAO;
import daos.impl.GeneralDAO;
import java.util.List;
import models.Employee;
import models.Job;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Aseprudin
 */
public class EmployeeController {

    private SessionFactory factory;
    private IGeneralDAO<Employee> iemployeedao;

    public EmployeeController(SessionFactory factory) {
        iemployeedao = new GeneralDAO<>(factory, Employee.class);
    }

    public String save(String id, String name, String email, String phoneNumber, String job) {
        if (iemployeedao.saveOrDelete(new Employee(phoneNumber, new Integer(id), name, email, new Job(new Integer(job))), true)) {
            return "Save Success";
        } else {
            return "Save Delete";
        }
    }
    
    public String delete(String id){
        if (iemployeedao.saveOrDelete(new Employee(new Integer(id)), false)) {
            return "Delete Success";
        } else {
            return "Delete Delete";
        }
    }
    
   public List<Employee> getAll(){
       return iemployeedao.getAll();
   }
   
   public Employee getById(String id){
       return iemployeedao.getByid(new Integer(id));
   }

}
