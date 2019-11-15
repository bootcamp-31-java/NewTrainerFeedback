/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.impl;

import daos.IGeneralDAO;
import daos.impl.GeneralDAO;
import java.util.List;
import models.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Aseprudin
 */
public class RoleController {
    private SessionFactory factory;
    private IGeneralDAO<Role> iroledao;

    public RoleController(SessionFactory factory) {
      iroledao = new GeneralDAO<>(factory, Role.class);
    }
    
    public String save(String id, String name){
        if (iroledao.saveOrDelete(new Role(new Integer(id), name), true)) {
            return "Save Success";
        } else {
            return "Save Failed";
        }
    }
    
    public String delete(String id){
        if (iroledao.saveOrDelete(new Role(new Integer(id)), false)) {
            return "Delete Success";
        } else {
            return "Delete Failed";
        }
    }
    
    public List<Role> getAll(){
        return iroledao.getAll();
    }
    
    public Role getById(String id){
        return iroledao.getByid(new Integer(id));
    }
}
