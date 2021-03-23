/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Dal.Repositories.DifficultyRepository;
import LPII02.Domain.Entities.Difficulty;

/**
 *
 * @author Gustavo
 */
public class DifficultyBusiness extends BaseBusiness<Difficulty> {

    public DifficultyBusiness() {
        super(Difficulty.class, new DifficultyRepository());
    }

    @Override
    public void insert(Difficulty model) throws Exception {
        if (model.getCode() <= 0) {
            throw new Exception("O código deve ser maior que zero.");
        }

        if (model.getDescription().length() == 0) {
            throw new Exception("O nome da dificuldade deve ser informado.");
        }

        Difficulty consult = null;

        try {
            consult = this.getByCode(model.getCode());
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro ao consultar a disponibilidade do código, "
                    + "tente novamente ou contate a equipe responsável.");
        }

        if (consult != null) {
            throw new Exception("Código já existente na base de dados, informe outro.");
        }

        try {
            super.insert(model);
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro ao inserir a dificuldade, tente novamente ou"
                    + "contate a equipe responsável.");
        }
    }

    public Difficulty getByCode(int code) throws Exception {
        try {
            return ((DifficultyRepository) this._repository).getByCode(code);
        } catch (Exception ex) {
            throw ex;
        }
    }
}
