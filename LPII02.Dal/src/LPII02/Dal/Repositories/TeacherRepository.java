/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Dal.Repositories;

import LPII02.Dal.Orm.HibernateUtil;
import LPII02.Domain.Entities.Teacher;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 *
 * @author Gustavo
 */
public class TeacherRepository extends BaseRepository<Teacher> {

    public TeacherRepository() {
        super(Teacher.class);
    }

    @Override
    public List<Teacher> get(boolean closeSession) {
        try {
            if (!this._session.isOpen()) {
                this._session = HibernateUtil.getSessionFactory().openSession();
            }

            SQLQuery query = this._session.createSQLQuery(
                    "select "
                    + "t.id,"
                    + "t.lastDegree,"
                    + "t.expecialization, "
                    + "u.name,"
                    + "u.login "
                    + "from "
                    + "Teacher t "
                    + "join [User] u on u.id=t.userId");

            List<Teacher> teachers = new ArrayList<Teacher>();
            List<Object[]> rows = query.list();

            for (Object[] row : rows) {
                Teacher t = new Teacher();

                t.setId(Integer.parseInt(row[0].toString()));
                t.setLastDegree(row[1].toString());
                t.setExpecialization(row[2].toString());
                t.setName(row[3].toString());
                t.setLogin(row[4].toString());

                teachers.add(t);
            }

            return teachers;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (closeSession) {
                this._session.close();
            }
        }
    }
}
