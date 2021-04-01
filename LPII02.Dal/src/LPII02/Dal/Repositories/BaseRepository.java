/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Dal.Repositories;

import LPII02.Dal.Orm.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gustavo
 */
public abstract class BaseRepository<T> {

    protected Class<T> _class;
    protected Session _session;

    public BaseRepository(Class<T> typeClass) {
        this._class = typeClass;
        this._session = HibernateUtil.getSessionFactory().openSession();
    }

    public BaseRepository(Class<T> typeClass, Session session) {
        this._class = typeClass;
        this._session = session;
    }

    public void insert(T model, boolean close) {
        if (!this._session.isOpen()) {
            this._session = HibernateUtil.getSessionFactory().openSession();
        }

        this._session.save(model);

        if (close) {
            this._session.flush();
            this._session.close();
        }
    }

    public void insert(List<T> models, boolean close) {
        Transaction transaction = null;

        try {
            transaction = this._session.getTransaction();

            if (transaction == null) {
                transaction = this._session.beginTransaction();
            }

            for (T item : models) {
                this._session.save(item);
            }

            transaction.commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        if (close) {
            this._session.close();
        }
    }

    public void update(T model, boolean close) {
        if (!this._session.isOpen()) {
            this._session = HibernateUtil.getSessionFactory().openSession();
        }

        this._session.update(model);

        if (close) {
            this._session.flush();
            this._session.close();
        }
    }

    public void update(List<T> models, boolean close) {
        Transaction transaction = null;

        try {
            transaction = this._session.getTransaction();

            if (transaction == null) {
                transaction = this._session.beginTransaction();
            }

            for (T item : models) {
                this._session.update(item);
            }

            transaction.commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        if (close) {
            this._session.close();
        }
    }

    public void delete(T model, boolean close) {
        if (!this._session.isOpen()) {
            this._session = HibernateUtil.getSessionFactory().openSession();
        }

        this._session.delete(model);

        if (close) {
            this._session.flush();
            this._session.close();
        }
    }

    public void delete(List<T> models, boolean close) {
        Transaction transaction = null;

        try {
            transaction = this._session.getTransaction();

            if (transaction == null) {
                transaction = this._session.beginTransaction();
            }

            for (T item : models) {
                this._session.delete(item);
            }

            transaction.commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        if (close) {
            this._session.close();
        }
    }

    public T get(int id, boolean closeSession) {
        try {
            if (!this._session.isOpen()) {
                this._session = HibernateUtil.getSessionFactory().openSession();
            }

            Query query = this._session.createQuery("from " + this._class.getName() + " where id=" + id);
            List<T> result = query.list();

            if (result == null || result.size() == 0) {
                return null;
            }

            return result.get(0);
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (closeSession) {
                this._session.close();
            }
        }
    }

    public List<T> get(int[] ids) {
        try {
            String unionIds = "";

            for (int id : ids) {
                unionIds += id + ",";
            }

            unionIds = unionIds.substring(0, unionIds.length() - 1);

            Query query = this._session.createQuery("from " + this._class.getName() + " where id in(" + unionIds + ")");

            return query.list();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this._session.close();
        }
    }

    public List<T> get(boolean closeSession) {
        try {
            if (!this._session.isOpen()) {
                this._session = HibernateUtil.getSessionFactory().openSession();
            }

            Query query = this._session.createQuery("from " + this._class.getName());
            return query.list();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (closeSession) {
                this._session.close();
            }
        }
    }
}
