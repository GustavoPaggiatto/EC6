/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Dal.Repositories;

import LPII02.Domain.Entities.Alternative;
import LPII02.Domain.Entities.Question;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Gustavo
 */
public class AlternativeRepository extends BaseRepository<Alternative> {
    
    public AlternativeRepository() {
        super(Alternative.class);
    }
    
    public AlternativeRepository(Session session) {
        super(Alternative.class, session);
    }
    
    public void deleteByQuestion(Question model) {
        Query query = this._session.createQuery("from " + this._class.getName() + " where questionId=" + model.getId());
        List<Alternative> result = query.list();
        
        if (result != null && result.size() > 0) {
            for (Alternative a : result) {
                this._session.delete(a);
            }
        }
    }
}
