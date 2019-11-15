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
import models.Materi;
import org.hibernate.SessionFactory;

/**
 *
 * @author Aseprudin
 */
public class MateriController {
    private SessionFactory factory;
    private IGeneralDAO<Materi> imateridao;

    public MateriController(SessionFactory factory) {
       imateridao = new GeneralDAO<>(factory, Materi.class);
    }
    
    public String save(String id, String name){
        if (imateridao.saveOrDelete(new Materi(new BigDecimal(id), name), true)) {
            return "Saved Success";
        } else {
            return "Saved Failed";
        }
    }
    
    public String delete(String id){
        if (imateridao.saveOrDelete(new Materi(new BigDecimal(id)), false)) {
            return "Delete Succes";
        } else {
            return "Delete Failed";
        }
    }
    
    public List<Materi> getAll(){
        return imateridao.getAll();
    }
    
    public Materi getById(String id){
        return imateridao.getByid(new BigDecimal(id));
    }
}
