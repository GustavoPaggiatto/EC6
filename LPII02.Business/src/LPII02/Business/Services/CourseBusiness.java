/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Dal.Repositories.CourseRepository;
import LPII02.Domain.Entities.Course;

/**
 *
 * @author Gustavo
 */
public class CourseBusiness extends BaseBusiness<Course> {

    public CourseBusiness() {
        super(Course.class, new CourseRepository());
    }
}
