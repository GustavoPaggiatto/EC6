/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Dal.Repositories.CourseRepository;
import LPII02.Domain.Entities.Course;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class CourseBusiness extends BaseBusiness<Course> {

    public CourseBusiness() {
        super(Course.class, new CourseRepository());
    }

    public String formatDuration(int duration) {
        return duration / 60 + ":" + duration % 60;
    }

    /*
    @Override
    public List<Course> get() {
        return this._repository.get(false); //lazy loading for lessons...
    }
     */
    @Override
    public void insert(Course model) throws Exception {
        this.commonValidations(model);

        try {
            String duration = String.valueOf(model.getDuration());
            int hours = Integer.parseInt(duration.substring(0, duration.length() - 2));
            int minutes = Integer.parseInt(duration.substring(duration.length() - 2));

            model.setDuration(hours * 60 + minutes);

            super.insert(model);
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro na base de dados ao cadastrar o curso, tente novamente.");
        }
    }

    @Override
    public void update(Course model) throws Exception {
        this.commonValidations(model);

        try {
            String duration = String.valueOf(model.getDuration());
            int hours = Integer.parseInt(duration.substring(0, duration.length() - 2));
            int minutes = Integer.parseInt(duration.substring(duration.length() - 2));

            model.setDuration(hours * 60 + minutes);

            super.update(model);
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro na base de dados ao alterar o curso, tente novamente.");
        }
    }

    public List<Course> get(int matterId, int teacherId, String name) throws Exception {
        try {
            List<Course> courses = ((CourseRepository) this._repository).get(false);

            if (matterId != 0) {
                courses.removeIf((t) -> {
                    return t.getMatter().getId() != matterId;
                });
            }

            if (teacherId != 0) {
                courses.removeIf((t) -> {
                    return t.getTeacher().getId() != teacherId;
                });
            }

            if (name != null && !name.isEmpty()) {
                courses.removeIf((t) -> {
                    return !t.getName().contains(name);
                });
            }

            return courses;
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro ao pesquisar os cursos, "
                    + "tente novamente ou contate a equipe responsável.");
        }
    }

    private void commonValidations(Course model) throws Exception {
        if (model.getMatter() == null || model.getMatter().getId() == 0) {
            throw new Exception("Matéria não informada, verifique.");
        }

        if (model.getName() == null || model.getName().length() == 0) {
            throw new Exception("Nome não informado, verifique.");
        }

        if (model.getTeacher() == null || model.getTeacher().getId() == 0) {
            throw new Exception("Professor não informado, verifique.");
        }

        if (model.getDuration() == 0) {
            throw new Exception("A duração do curso deve ser maior que zero.");
        }
    }
}
