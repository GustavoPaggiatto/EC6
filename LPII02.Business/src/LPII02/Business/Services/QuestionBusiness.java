/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Dal.Repositories.QuestionRepository;
import LPII02.Domain.Entities.Question;
import java.util.List;

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
}
