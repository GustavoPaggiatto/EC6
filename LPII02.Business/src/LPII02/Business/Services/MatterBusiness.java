/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Dal.Repositories.MatterRepository;
import LPII02.Domain.Entities.Matter;

/**
 *
 * @author Gustavo
 */
public class MatterBusiness extends BaseBusiness<Matter> {
    
    public MatterBusiness() {
        super(Matter.class, new MatterRepository());
    }
    
    @Override
    public void insert(Matter model) throws Exception {
        if (model.getCode() <= 0) {
            throw new Exception("O código deve ser maior que zero.");
        }
        
        if (model.getName().length() == 0) {
            throw new Exception("O nome da matéria deve ser informado.");
        }
        
        Matter consult = null;
        
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
            throw new Exception("Ocorreu um erro ao inserir a matéria, tente novamente ou"
                    + "contate a equipe responsável.");
        }
    }
    
    @Override
    public void update(Matter model) throws Exception {
        if (model.getCode() == 0) {
            throw new Exception("Código não existente, verifique.");
        }
        
        if (model.getName().length() == 0) {
            throw new Exception("O nome da matéria deve ser informado.");
        }
        
        Matter consult = null;
        
        try {
            consult = this.getByCode(model.getCode());
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro ao consultar a disponibilidade do código, "
                    + "tente novamente ou contate a equipe responsável.");
        }
        
        if (consult == null) {
            throw new Exception("Código inexistente, verifique.");
        }
        
        try {
            model.setId(consult.getId());
            
            super.update(model);
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro ao efetuar a alteração da matéria, "
                    + "tente novamente ou contate a equipe responsável.");
        }
    }
    
    public Matter getByCode(int code) throws Exception {
        try {
            return ((MatterRepository) this._repository).getByCode(code);
        } catch (Exception ex) {
            throw ex;
        }
    }
}
