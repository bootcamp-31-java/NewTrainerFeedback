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
import models.Room;
import org.hibernate.SessionFactory;

/**
 *
 * @author Aseprudin
 */
public class RoomController {
    private SessionFactory factory;
    private IGeneralDAO<Room> iroomdao;

    public RoomController(SessionFactory factory) {
        iroomdao = new GeneralDAO<>(factory, Room.class);
    }
    
    public String save (String id, String name) {
        if (iroomdao.saveOrDelete(new Room(new BigDecimal(id), name), true)) {
            return "Save Success";
        } else {
            return "Save Failed";
        }
    }
    
    public String delete(String id){
        if (iroomdao.saveOrDelete(new Room(new BigDecimal(id)), false)) {
            return "Delete Success";
        } else {
            return "Delete Failed";
        }
    }
    
    public List<Room> getAll(){
        return iroomdao.getAll();
    }
    
    public Room getById(String id){
        return iroomdao.getByid(new BigDecimal(id));
    }
    
}
