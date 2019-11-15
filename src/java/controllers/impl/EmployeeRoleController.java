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
import models.EmployeeRole;
import models.Role;
import org.hibernate.SessionFactory;

/**
 *
 * @author Aseprudin
 */
public class EmployeeRoleController {
    private SessionFactory factory;
    private IGeneralDAO<EmployeeRole> iecdao;

    public EmployeeRoleController(SessionFactory factory) {
        iecdao = new GeneralDAO<>(factory, EmployeeRole.class);
    }
    
    public String save(String employee, String role){
        if (iecdao.saveOrDelete(new EmployeeRole(new Employee(new Integer(employee)), new Role(new Integer(role))), true)) {
            return "Save Success";
        } else {
            return "Save Faild";
        }
    }
    
    public String delete(String id){
        if (iecdao.saveOrDelete(new EmployeeRole(new Integer(id)), false)) {
            return "delete Success";
        } else {
            return "delete Failed";
        }
    }
    
    public List<EmployeeRole> getAll(){
        return iecdao.getAll();
    }
    
    public EmployeeRole getById(String id){
        return iecdao.getByid(new Integer(id));
    }
    
    
}
