/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Dal.Repositories.BaseRepository;
import LPII02.Dal.Repositories.TeacherRepository;
import LPII02.Domain.Entities.Teacher;

/**
 *
 * @author Gustavo
 */
public class TeacherBusiness extends BaseBusiness<Teacher> {

    public TeacherBusiness() {
        super(Teacher.class, new TeacherRepository());
    }

}
