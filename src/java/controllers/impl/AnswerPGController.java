/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.impl;

import daos.IGeneralDAO;
import daos.impl.GeneralDAO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import models.AnswerPg;
import models.Form;
import models.Question;
import org.hibernate.SessionFactory;

/**
 *
 * @author Aseprudin
 */
public class AnswerPGController {
    private SessionFactory factory;
    private IGeneralDAO<AnswerPg> ianswerpgdao;

    public AnswerPGController(SessionFactory factory) {
        ianswerpgdao = new GeneralDAO<>(factory, AnswerPg.class);
    }
    
    public String save(String id, String scala, String note, String question, String form){
        if (ianswerpgdao.saveOrDelete(new AnswerPg(new BigDecimal(id), new BigInteger(scala), note, new Form(new BigDecimal(form)), new Question(new BigDecimal(question))), true)) {
            return "Save Success";
        } else {
            return "Save Failed";
        }
    }
    
    public String delete(String id){
        if (ianswerpgdao.saveOrDelete(new AnswerPg(new BigDecimal(id)), false)) {
            return "Delete Berhasil";
        } else {
            return "Delete Failed";
        }
    }
    
    public List<AnswerPg> getAll(){
        return ianswerpgdao.getAll();
    }
    
    public AnswerPg getById(String id){
        return ianswerpgdao.getByid(new BigDecimal(id));
    }
    
    
}
