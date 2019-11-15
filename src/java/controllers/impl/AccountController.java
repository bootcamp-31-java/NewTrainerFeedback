/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.impl;

import daos.IGeneralDAO;
import daos.impl.GeneralDAO;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import models.Account;
import models.Employee;
import models.Status;
import org.hibernate.SessionFactory;

/**
 *
 * @author Aseprudin
 */
public class AccountController {
    
    private SessionFactory factory;
    private IGeneralDAO<Account> iaccountdao;
    
    public AccountController(SessionFactory factory) {
        iaccountdao = new GeneralDAO<>(factory, Account.class);
    }
    
    public String save(String employee, String password, String token, String expiredDate, String status){
        if (iaccountdao.saveOrDelete(new Account(new Integer(employee), password, token, new Date(expiredDate), new Status(new BigDecimal(status))), true)) {
            return "Save Success";
        } else {
            return "Save Fail";
        }
    }
    
    public String delete(String employee){
        if (iaccountdao.saveOrDelete(new Account(new Integer(employee)), false)) {
            return "Delete Success";
        } else {
            return "Delete Faild";
        }
    }
    
    public List<Account> getAll(){
        return iaccountdao.getAll();
    }
    
    public Account getById(String employee){
        return iaccountdao.getByid(new Integer(employee));
    }
  
}
