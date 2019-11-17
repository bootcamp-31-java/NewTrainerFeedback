/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.impl;

import daos.IAvgDAO;
import java.util.ArrayList;
import java.util.List;
import models.AnswerPg;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author G551VW
 */
public class AvgDAO implements IAvgDAO {

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public AvgDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public List<AnswerPg> avgData() {
        List<AnswerPg> entitys = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            entitys = (List<AnswerPg>) session.createQuery("SELECT AVG(scala), question, form FROM AnswerPg GROUP BY question").list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return entitys;
    }
}
