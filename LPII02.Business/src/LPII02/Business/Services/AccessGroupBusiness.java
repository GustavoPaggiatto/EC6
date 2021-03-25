/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Dal.Repositories.AccessGroupRepository;
import LPII02.Domain.Entities.AccessGroup;

/**
 *
 * @author Gustavo
 */
public class AccessGroupBusiness extends BaseBusiness<AccessGroup> {

    public AccessGroupBusiness() {
        super(AccessGroup.class, new AccessGroupRepository());
    }

    @Override
    public void insert(AccessGroup model) throws Exception {
        if (model.getName() == null
                || model.getName().length() == 0) {
            throw new Exception("O nome deve ser informado.");
        }

        if (model.getDescription() == null
                || model.getDescription().length() == 0) {
            throw new Exception("A descrição do grupo deve ser informada");
        }

        AccessGroup consult = null;

        try {
            consult = this.getByName(model.getName());
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro ao pesquisar a disponibilidade do nome do grupo, "
                    + "tente novamente ou contate a equipe responsável.");
        }

        if (consult != null) {
            throw new Exception("Nome já existente na base de dados, informe outro.");
        }

        try {
            super.insert(model);
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro ao inserir o grupo de acesso, tente novamente ou"
                    + "contate a equipe responsável.");
        }
    }

    @Override
    public void update(AccessGroup model) throws Exception {
        if (model.getName() == null
                || model.getName().length() == 0) {
            throw new Exception("O nome deve ser informado.");
        }

        if (model.getDescription() == null
                || model.getDescription().length() == 0) {
            throw new Exception("A descrição do grupo deve ser informada");
        }

        AccessGroup consult = null;

        try {
            consult = this.getByName(model.getName());
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro ao pesquisar a disponibilidade do nome do grupo, "
                    + "tente novamente ou contate a equipe responsável.");
        }

        if (consult == null) {
            throw new Exception("Grupo inexistente, verifique.");
        }

        try {
            model.setId(consult.getId());
            super.update(model);
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro ao alterar o grupo de acesso, tente novamente ou"
                    + "contate a equipe responsável.");
        }
    }

    public AccessGroup getByName(String name) throws Exception {
        return ((AccessGroupRepository) this._repository).getByName(name);
    }
}
