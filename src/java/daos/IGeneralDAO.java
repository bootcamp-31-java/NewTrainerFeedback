/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.io.Serializable;
import java.util.List;
import models.Account;

/**
 *
 * @author Aseprudin
 */
public interface IGeneralDAO<T> {
    
    List<T> getAll();
    
    T getByid(Object id);
    
    boolean saveOrDelete(T t, boolean isSave);
   
    List<Account> getPassByEmail(String email);
        
    boolean getToken(String token);
    
    Account getByEmail(String email);
    
    boolean getEmployeeId(Integer employeeId);
    
    boolean getCekEmployeesId(Integer employeeId);
    
    boolean getCekEmail(String employeeId);
    
    Account getByToken(String token);
    
     /**
     * ini fungsi untuk mendapatkan hasil yang unik sesuai kata kunci
     *
     * @param entity parameter entity merupakan object model
     * @param category parameter category berupa atribut yang ada di object
     * model
     * @param key parameter key berupa String
     * @return return berupa daftar dari parameter entity
     */
    public T getUser(T entity, String category, Object key);
    
    public T getUserById(Class clas, Serializable id);
    
    /**
     * ini fungsi untuk menampilkan semua data dari object model
     *
     * @param entity entity merupakan object model
     * @return return berupa daftar dari object model
     */
    public List<T> getAll(T entity);
    
    /**
     * ini fungsi untuk mendapatkan hasil yang persis dengan kata kunci
     *
     * @param entity parameter entity merupakan object model
     * @param category parameter category berupa atribut yang ada di object
     * model
     * @param key parameter key berupa String
     * @return return berupa daftar dari parameter entity
     */
    public List<T> getValid(T entity, String category, Object key);
    
    public boolean insertUpdateDelete(T entity, boolean isDel);
    
    public T countData(T entity);

     public List<T> historyDate(T entity);
}
