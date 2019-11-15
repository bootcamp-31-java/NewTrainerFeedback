/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.impl;

import daos.IGeneralDAO;
import java.util.List;
import models.Job;
import org.hibernate.SessionFactory;

/**
 *
 * @author Aseprudin
 */
public class JobController {
    private SessionFactory factory;
    private IGeneralDAO<Job> ijobdao;

    public JobController(SessionFactory factory) {
        this.factory = factory;
    }
    
   public String save(String id, String name){
       if (ijobdao.saveOrDelete(new Job(new Integer(id), name), true)) {
           return "Save Success";
       } else {
           return "Save failed";
       }
   }
   
   public String delete(String id){
       if (ijobdao.saveOrDelete(new Job(new Integer(id)), false)) {
           return "Delete SUccess";
       } else {
           return "Delete Failed";
       }
   }
   
   public List<Job> getAll(){
       return ijobdao.getAll();
   }
   
   public Job getById(String id){
       return ijobdao.getByid(new Integer(id));
   }
    
}
