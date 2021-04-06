/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Dal.Repositories.AlternativeRepository;
import LPII02.Domain.Entities.Alternative;
import LPII02.Domain.Entities.Question;
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
        if (model.getContent() == null) {
            throw new Exception("O conteúdo da alternativa não foi informado.");
        }

        model.setContent(model.getContent().trim());

        if (model.getContent().length() == 0) {
            throw new Exception("O conteúdo da alternativa não foi informado.");
        }

        model.setInsertDate(new Date());

        try {
            super.insert(model);
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro ao inserir a alternativa, tente novamente ou"
                    + "contate a equipe responsável.");
        }
    }

    public List<Alternative> getByQuestion(Question model) throws Exception {
        return ((AlternativeRepository) this._repository).getByQuestion(model, true);
    }
}
