/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Dal.Repositories.QuestionRepository;
import LPII02.Domain.Entities.Question;
import LPII02.Domain.Entities.TestQuestion;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Gustavo
 */
public class QuestionBusiness extends BaseBusiness<Question> {
    
    public QuestionBusiness() {
        super(Question.class, new QuestionRepository());
    }
    
    @Override
    public List<Question> get() {
        return this._repository.get(false);
    }
    
    @Override
    public Question get(int id) {
        return this._repository.get(id, false);
    }
    
    @Override
    public void insert(Question model) throws Exception {
        this.commonValidation(model);
        model.setFileGuid(UUID.randomUUID().toString());
        
        try {
            super.insert(model);
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro ao inserir a questão, tente novamente ou"
                    + "contate a equipe responsável.");
        }
    }
    
    @Override
    public void update(Question model) throws Exception {
        this.commonValidation(model);
        
        try {
            super.update(model);
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro ao alterar a questão, tente novamente ou"
                    + "contate a equipe responsável.");
        }
    }
    
    @Override
    public void delete(Question model) throws Exception {
        TestQuestionBusiness tqBusiness = new TestQuestionBusiness();
        List<TestQuestion> tests = null;
        
        try {
            tests = tqBusiness.getByQuestion(model);
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro ao consultar os testes vinculados a questão, "
                    + "tente novamente ou contate a equipe responsável.");
        }
        
        if (tests != null && tests.size() > 0) {
            throw new Exception("Não é possível excluir essa questão, pois há provas que utilizam ela.");
        }
        
        try {
            super.delete(model);
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro ao excluir a questão, "
                    + "tente novamente ou contate a equipe responsável.");
        }
    }
    
    private void commonValidation(Question model) throws Exception {
        if (model.getMatter() == null
                || model.getMatter().getId() == 0) {
            throw new Exception("Matéria não informada.");
        }
        
        if (model.getDifficulty() == null
                || model.getDifficulty().getId() == 0) {
            throw new Exception("Dificuldade não informada.");
        }
        
        if (model.getAnswer() != null) {
            model.setAnswer(model.getAnswer().trim());
        }
        
        if (model.getAnswer() == null
                || model.getAnswer().length() == 0) {
            throw new Exception("Resposta não foi informada.");
        }
        
        if (model.getEnunciated() != null) {
            model.setEnunciated(model.getEnunciated().trim());
        }
        
        if (model.getEnunciated() == null
                || model.getEnunciated().length() == 0) {
            throw new Exception("Enunciado não informado.");
        }
    }
}
