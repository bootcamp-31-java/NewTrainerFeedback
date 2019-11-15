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
import models.AnswerEssay;
import models.Form;
import models.Question;
import org.hibernate.SessionFactory;

/**
 *
 * @author Aseprudin
 */
public class AnswerEssayController {
    private SessionFactory factory;
    private IGeneralDAO<AnswerEssay> iansweressaydao;

    public AnswerEssayController(SessionFactory factory) {
        iansweressaydao = new GeneralDAO<>(factory, AnswerEssay.class);
    }
    
    public String save(String id, String detail, String question, String form){
        if (iansweressaydao.saveOrDelete(new AnswerEssay(new BigDecimal(id), detail, new Form(new BigDecimal(id)), new Question(new BigDecimal(id))), true)) {
            return "save berhasil";
        } else {
            return "save failed";
        }
    }
    
    public String delete (String id){
        if (iansweressaydao.saveOrDelete(new AnswerEssay(new BigDecimal(id)), false)) {
            return "Delete berhasil";
        } else {
            return "Delete failed";
        }
    }
    
    public List<AnswerEssay> getAll(){
        return iansweressaydao.getAll();
    }
    
    public AnswerEssay getById(String id){
        return iansweressaydao.getByid(new BigDecimal(id));
    }
}
