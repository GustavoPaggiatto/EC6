/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Dal.Repositories;

import LPII02.Dal.Orm.HibernateUtil;
import LPII02.Domain.Entities.Question;
import LPII02.Domain.Entities.TestQuestion;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Gustavo
 */
public class TestQuestionRepository extends BaseRepository<TestQuestion> {

    public TestQuestionRepository() {
        super(TestQuestion.class);
    }

    public List<TestQuestion> getByQuestion(Question model) {
        try {
            if (!this._session.isOpen()) {
                this._session = HibernateUtil.getSessionFactory().openSession();
            }

            Query query = this._session.createQuery("from " + this._class.getName() + " where questionId=" + model.getId());
            List<TestQuestion> result = query.list();

            return result;
        } catch (Exception ex) {
            throw ex;
        } finally {
            this._session.close();
        }
    }
}
