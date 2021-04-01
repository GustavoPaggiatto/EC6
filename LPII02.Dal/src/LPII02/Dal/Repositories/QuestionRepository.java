/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Dal.Repositories;

import LPII02.Domain.Entities.Question;

/**
 *
 * @author Gustavo
 */
public class QuestionRepository extends BaseRepository<Question> {

    public QuestionRepository() {
        super(Question.class);
    }

}
