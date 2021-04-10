/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Dal.Repositories;

import LPII02.Domain.Entities.Course;

/**
 *
 * @author Gustavo
 */
public class CourseRepository extends BaseRepository<Course> {

    public CourseRepository() {
        super(Course.class);
    }

}
