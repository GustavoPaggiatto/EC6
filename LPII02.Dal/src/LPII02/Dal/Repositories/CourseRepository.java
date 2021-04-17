/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Dal.Repositories;

import LPII02.Dal.Orm.HibernateUtil;
import LPII02.Domain.Entities.Course;
import org.hibernate.Transaction;

/**
 *
 * @author Gustavo
 */
public class CourseRepository extends BaseRepository<Course> {

    public CourseRepository() {
        super(Course.class);
    }

    @Override
    public void delete(Course model, boolean close) {
        if (!this._session.isOpen()) {
            this._session = HibernateUtil.getSessionFactory().openSession();
        }

        try {
            Transaction transaction = this._session.beginTransaction();
            LessonRepository lRepository = new LessonRepository(this._session);

            lRepository.deleteByCourse(model);

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
