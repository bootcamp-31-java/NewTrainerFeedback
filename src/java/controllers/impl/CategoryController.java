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
import models.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Aseprudin
 */
public class CategoryController {
    private SessionFactory factory;
    private IGeneralDAO<Category> icategorydao;

    public CategoryController(SessionFactory factory) {
        icategorydao = new GeneralDAO<>(factory, Category.class);
    }
    
    public String save(String id, String name, String type){
        if (icategorydao.saveOrDelete(new Category(new BigDecimal(id), name, type), true)) {
            return "Save Success";
        } else {
            return "Save Delete";
        }
    }
    
    public String delete(String id){
        if (icategorydao.saveOrDelete(new Category(new BigDecimal(id)), false)) {
            return "Delete Success";
        } else {
            return "Delete failed";
        }
    }
    
    public List<Category> getAll(){
        return icategorydao.getAll();
    }
    
    public Category getById(String id){
        return icategorydao.getByid(new BigDecimal(id));
    }
}
