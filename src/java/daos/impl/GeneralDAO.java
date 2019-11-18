/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.impl;

import daos.IGeneralDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Account;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Aseprudin
 */
public class GeneralDAO<T> implements IGeneralDAO<T> {

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    private T model;

    public GeneralDAO(SessionFactory factory, Class<T> model) {
        try {
            this.factory = factory;
            this.model = model.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GeneralDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<T> getAll() {
        List<T> rs = new ArrayList<>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            rs = session.createQuery("from " + model.getClass().getSimpleName()).list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return rs;
    }

    @Override
    public T getByid(Object id) {
        T models = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from" + model.getClass().getSimpleName() + "where id = :id");
            query.setParameter("id", id);
            models = (T) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return models;
    }

    @Override
    public boolean saveOrDelete(T t, boolean isSave) {
        boolean result = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            if (isSave) {
                session.saveOrUpdate(t);
            } else {
                session.delete(t);
            }
            result = true;
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<Account> getPassByEmail(String email) {
        List<Account> listAccount = new ArrayList<>();
        Account account = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Account where email = :email");
            query.setParameter("email", email);
            account = (Account) query.uniqueResult();
            listAccount.add(account);
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return listAccount;
    }

    @Override
    public boolean getToken(String token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account getByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getEmployeeId(Integer employeeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getCekEmployeesId(Integer employeeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getCekEmail(String employeeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account getByToken(String token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T getUser(T entity, String category, Object key) {
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        T entities = null;
        try {
            Criteria crit = session.createCriteria(entity.getClass());
            Criterion cat = Restrictions.like(category, key + "%", MatchMode.EXACT);
            crit.add(cat);
            entities = (T) crit.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return entities;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T getUserById(Class clas, Serializable id) {
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        T entity = null;
        try {
            entity = (T) session.load(clas, id);
            Hibernate.initialize(entity);
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return entity;
    }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    @Override
    public List<T> getAll(T entity) {
        List<T> entities = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();

        try {
            entities = session.createQuery("FROM " + entity.getClass().getSimpleName() + " ORDER BY 1").list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return entities;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> getValid(T entity, String category, Object key) {
        List<T> entities = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {

            Criteria crit = session.createCriteria(entity.getClass());
            Criterion cat = Restrictions.like(category, key + "%", MatchMode.EXACT);
            Disjunction disj = Restrictions.disjunction();
            disj.add(cat);
            crit.add(disj);
            entities = crit.list();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return entities;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertUpdateDelete(T entity, boolean isDel) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            if (isDel == true) {
                session.delete(entity);
            } else {
                session.saveOrUpdate(entity);
            }
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T countData(T entity) {
        T entitys = null;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            entitys = (T) session.createQuery("SELECT COUNT(*)+1 FROM " + entity.getClass().getSimpleName()).uniqueResult();
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

    @Override
    public List<T> historyDate(T entity) {
        List<T> entities = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            entities = (List<T>) session.createQuery("From Shcedule where Sysdate > eventDate");
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return entities;
    }

}
