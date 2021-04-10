/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Dal.Repositories.AlternativeRepository;
import LPII02.Domain.Entities.Alternative;
import LPII02.Domain.Entities.Question;
import LPII02.Domain.Entities.TestQuestion;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class AlternativeBusiness extends BaseBusiness<Alternative> {

    public AlternativeBusiness() {
        super(Alternative.class, new AlternativeRepository());
    }

    @Override
    public void insert(Alternative model) throws Exception {
        this.commonValidations(model);
        model.setInsertDate(new Date());

        try {
            super.insert(model);
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro ao inserir a alternativa, tente novamente ou"
                    + "contate a equipe responsável.");
        }
    }

    @Override
    public void update(Alternative model) throws Exception {
        TestQuestionBusiness tqBusiness = new TestQuestionBusiness();
        List<TestQuestion> tqs = null;

        try {
            tqs = tqBusiness.getByQuestion(model.getQuestion());
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro ao consultar os testes vinculados a questão das alternativas,"
                    + " tente novamente ou contate a equipe responsável.");
        }

        if (tqs != null && tqs.size() > 0) {
            throw new Exception("Há testes vinculados a esta questão, portanto não será possível alterar suas alternativas"
                    + " no momento.");
        }

        boolean isAnswer = false;
        QuestionBusiness qBusiness = new QuestionBusiness();
        Alternative reset = this.getInstance();
        Question q = null;

        try {
            reset = this._repository.get(model.getId(), true);
            q = qBusiness.get(model.getQuestion().getId());

            if (q.getAnswer().equals(reset.getContent())) {
                isAnswer = true;
            }
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro durante a verificação da resposta da questão (necessário durante a alteração de alternativas), "
                    + "tente novamente ou contate a equipe responsável.");
        }

        try {
            reset.setContent(model.getContent());
            reset.setQuestion(model.getQuestion());

            super.update(reset);
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro ao efetivar a alteração na alternativa, "
                    + "tente novamente ou contate a equipe responsável.");
        }

        if (isAnswer) {
            try {
                q.setAnswer(model.getContent());
                qBusiness.update(q);
            } catch (Exception ex) {
                //nothing...
                //the system will point to this in dashboard...
            }
        }
    }

    @Override
    public void delete(Alternative model) throws Exception {
        if (model.getId() == 0) {
            throw new Exception("Nenhum alternativa foi selecionada.");
        }

        TestQuestionBusiness tqBusiness = new TestQuestionBusiness();
        List<TestQuestion> tqs = null;

        try {
            tqs = tqBusiness.getByQuestion(model.getQuestion());
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro ao consultar os testes vinculados a questão das alternativas,"
                    + " tente novamente ou contate a equipe responsável.");
        }

        if (tqs != null && tqs.size() > 0) {
            throw new Exception("Há testes vinculados a esta questão, portanto não será possível alterar suas alternativas"
                    + " no momento.");
        }

        Alternative reset = this._repository.get(model.getId(), true);
        QuestionBusiness qBusiness = new QuestionBusiness();
        Question q = qBusiness.get(model.getQuestion().getId());

        if (q.getAnswer().equals(reset.getContent())) {
            throw new Exception("Essa alternativa é a resposta da questão, primeiro altere a resposta "
                    + "antes de prosseguir com a exclusão.");
        }

        try {
            super.delete(reset);
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro ao excluir a alternativa, "
                    + "tente novamente ou contate a equipe responsável.");
        }
    }

    public List<Alternative> getByQuestion(Question model) throws Exception {
        return ((AlternativeRepository) this._repository).getByQuestion(model, true);
    }

    private void commonValidations(Alternative model) throws Exception {
        if (model.getContent() == null) {
            throw new Exception("O conteúdo da alternativa não foi informado.");
        }

        model.setContent(model.getContent().trim());

        if (model.getContent().length() == 0) {
            throw new Exception("O conteúdo da alternativa não foi informado.");
        }
    }
}
