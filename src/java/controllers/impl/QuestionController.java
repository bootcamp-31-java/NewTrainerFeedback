/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.impl;

import daos.impl.GeneralDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Category;
import models.Question;
import org.hibernate.SessionFactory;

/**
 *
 * @author Aseprudin
 */
public class QuestionController {
    private SessionFactory factory;
    private GeneralDAO<Question> iquestiondao;

    public QuestionController(SessionFactory factory) {
        iquestiondao = new GeneralDAO<>(factory, Question.class);
    }
    
    public String save(String id, String question, String category){
        if (iquestiondao.saveOrDelete(new Question(new BigDecimal(id), question, new Category(new BigDecimal(category))), true)) {
            return "Save Success";
        } else {
            return "Save Failed";
        }   
    }
    
    public String delete(String id){
        if (iquestiondao.saveOrDelete(new Question(new BigDecimal(id)), false)) {
            return "Delete Success";
        } else {
            return "Delete Failed";
        }
    }
    
    public List<Question> getAll(){
        return iquestiondao.getAll();
    }
    
    public Question getById(String id){
        return iquestiondao.getByid(new BigDecimal(id));
    }
    
}
