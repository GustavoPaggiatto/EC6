/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Dal.Repositories;

import LPII02.Dal.Orm.HibernateUtil;
import LPII02.Domain.Entities.Course;
import LPII02.Domain.Entities.Lesson;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Gustavo
 */
public class LessonRepository extends BaseRepository<Lesson> {

    public LessonRepository() {
        super(Lesson.class);
    }

    public LessonRepository(Session session) {
        super(Lesson.class, session);
    }

    public void deleteByCourse(Course course) {
        Query query = this._session.createQuery("from " + this._class.getName() + " where courseId=" + course.getId());
        List<Lesson> result = query.list();

        if (result != null && result.size() > 0) {
            for (Lesson l : result) {
                this._session.delete(l);
            }
        }
    }

    public List<Lesson> getByCourse(Course course) throws Exception {
        try {
            if (!this._session.isOpen()) {
                this._session = HibernateUtil.getSessionFactory().openSession();
            }

            Query query = this._session.createQuery("from Lesson where courseId=" + course.getId());
            List<Lesson> result = query.list();

            return result;
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro na base de dados ao recuperar as aulas "
                    + "do curso selecionado, tente novamente.");
        } finally {
            this._session.close();
        }
    }
}
