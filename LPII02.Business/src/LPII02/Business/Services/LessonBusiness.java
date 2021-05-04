/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Dal.Repositories.LessonRepository;
import LPII02.Domain.Entities.Course;
import LPII02.Domain.Entities.Lesson;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    
    @Override
    public void insert(Lesson model) throws Exception {
        this.commonValidation(model);
        model.setLessonGuid(UUID.randomUUID().toString());
        
        List<Lesson> lessons = null;
        List<Lesson> lessonsChange = null;
        
        try {
            lessons = ((LessonRepository) this._repository).getByCourse(model.getCourse());
            
            if (lessons != null) {
                for (Lesson l : lessons) {
                    if (l.getOrder() >= model.getOrder()) {
                        if (lessonsChange == null) {
                            lessonsChange = new ArrayList<Lesson>();
                        }
                        
                        l.setOrder(l.getOrder() + 1);
                        lessonsChange.add(l);
                    }
                }
            }
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro durante a pesquisa das aulas do curso para "
                    + "a alteração da ordem, caso necessário. Tente novamente ou contate a "
                    + "equipe responsável.");
        }
        
        try {
            super.insert(model);
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro ao inserir a aula, tente novamente ou"
                    + "contate a equipe responsável.");
        }
        
        try {
            if (lessonsChange != null) {
                this.update(lessonsChange);
            }
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro ao alterar as ordens das outras aulas, "
                    + "tente novamente ou contate a equipe responsável.");
        }
    }
    
    private void commonValidation(Lesson model) throws Exception {
        if (model.getContent() == null) {
            throw new Exception("O vídeo da aula não informado!");
        }
        
        if (model.getContent().length == 0) {
            throw new Exception("O vídeo da aula é um arquivo vazio, verifique.");
        }
        
        if (model.getName() == null || model.getName().trim().length() == 0) {
            throw new Exception("O nome da aula não informado, verifique");
        }
        
        if (model.getOrder() <= 0) {
            throw new Exception("A ordem da aula deve ser posivitiva, verifique.");
        }
        
        if (model.getResume() == null || model.getResume().trim().length() == 0) {
            throw new Exception("O resumo da aula não foi preenchido, verifique.");
        }
    }
}
