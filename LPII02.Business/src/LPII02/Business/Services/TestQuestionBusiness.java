/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Dal.Repositories.TestQuestionRepository;
import LPII02.Domain.Entities.TestQuestion;
import LPII02.Domain.Entities.Question;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class TestQuestionBusiness extends BaseBusiness<TestQuestion> {

    public TestQuestionBusiness() {
        super(TestQuestion.class, new TestQuestionRepository());
    }

    public List<TestQuestion> getByQuestion(Question model) {
        return ((TestQuestionRepository) this._repository).getByQuestion(model);
    }
}
