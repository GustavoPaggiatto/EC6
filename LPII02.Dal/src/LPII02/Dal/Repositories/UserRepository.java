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
    
     public User search_User( ) {
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
   
}
    

