/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Dal.Repositories;

import LPII02.Dal.Orm.HibernateUtil;
import LPII02.Domain.Entities.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gustavo
 */
public class UserRepository extends BaseRepository<User> {

    public UserRepository() {
        super(User.class);
    }

    public User search_User() {
        try {
            if (!this._session.isOpen()) {
                this._session = HibernateUtil.getSessionFactory().openSession();
            }
            Query query = this._session.createQuery(" select * from User where name like '%...%'");
            List<User> result = query.list();

            if (result == null || result.size() == 0) {
                return null;
            }
            return result.get(0);
        } catch (Exception ex) {
            throw ex;
        } finally {
            this._session.close();
        }
    }

    public User login(String login, String password) {
        try {
            if (!this._session.isOpen()) {
                this._session = HibernateUtil.getSessionFactory().openSession();
            }
            Query query = this._session.createSQLQuery("select u.id,u.name,u.login from [User] u where u.login='" + login + "' and u.password='" + password + "'");
            List<Object[]> rows = query.list();

            if (rows == null || rows.size() == 0) {
                return null;
            }

            User user = new User();
            user.setId(Integer.parseInt(rows.get(0)[0].toString()));
            user.setName(rows.get(0)[1].toString());
            user.setLogin(rows.get(0)[2].toString());

            return user;
        } catch (Exception ex) {
            throw ex;
        } finally {
            this._session.close();
        }
    }

}
