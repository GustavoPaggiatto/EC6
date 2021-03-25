/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Dal.Repositories.BaseRepository;
import LPII02.Dal.Repositories.PermissionRepository;
import LPII02.Domain.Entities.Permission;

/**
 *
 * @author Gustavo
 */
public class PermissionBusiness extends BaseBusiness<Permission> {

    public PermissionBusiness() {
        super(Permission.class, new PermissionRepository());
    }

    @Override
    public void insert(Permission model) throws Exception {
        if (model.getCode() <= 0) {
            throw new Exception("O código deve ser maior que zero.");
        }

        if (model.getName().length() == 0) {
            throw new Exception("O descrição da permissão deve ser informado.");
        }

        Permission consult = null;

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
            throw new Exception("Ocorreu um erro ao inserir a permissão, tente novamente ou"
                    + "contate a equipe responsável.");
        }
    }

    @Override
    public void update(Permission model) throws Exception {
        if (model.getCode() == 0) {
            throw new Exception("Código não existente, verifique.");
        }

        if (model.getName().length() == 0) {
            throw new Exception("O nome da permissão deve ser informado.");
        }

        Permission consult = null;

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
            throw new Exception("Ocorreu um erro ao efetuar a alteração da permissão, "
                    + "tente novamente ou contate a equipe responsável.");
        }
    }

    public Permission getByCode(int code) throws Exception {
        return ((PermissionRepository) this._repository).getByCode(code);
    }
}
