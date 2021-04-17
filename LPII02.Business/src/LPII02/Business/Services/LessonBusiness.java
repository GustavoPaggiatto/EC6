/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Dal.Repositories.LessonRepository;
import LPII02.Domain.Entities.Course;
import LPII02.Domain.Entities.Lesson;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class LessonBusiness extends BaseBusiness<Lesson> {

    public LessonBusiness() {
        super(Lesson.class, new LessonRepository());
    }

    public List<Lesson> getByCourse(Course course) throws Exception {
        return ((LessonRepository) this._repository).getByCourse(course);
    }
}
