/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Dal.Repositories;

import LPII02.Dal.Orm.HibernateUtil;
import LPII02.Domain.Entities.Question;
import org.hibernate.Transaction;

/**
 *
 * @author Gustavo
 */
public class QuestionRepository extends BaseRepository<Question> {

    public QuestionRepository() {
        super(Question.class);
    }

    @Override
    public void delete(Question model, boolean close) {
        if (!this._session.isOpen()) {
            this._session = HibernateUtil.getSessionFactory().openSession();
        }

        try {
            Transaction transaction = this._session.beginTransaction();

            AlternativeRepository aRepository = new AlternativeRepository(this._session);

            aRepository.deleteByQuestion(model);

            this._session.delete(model);

            transaction.commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (close) {
                this._session.flush();
                this._session.close();
            }
        }
    }
}
