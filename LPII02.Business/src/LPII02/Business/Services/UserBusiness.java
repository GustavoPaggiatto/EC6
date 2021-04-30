/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Dal.Repositories.UserRepository;
import LPII02.Domain.Entities.User;
import java.util.UUID;

/**
 *
 * @author Gustavo
 */
public class UserBusiness extends BaseBusiness<User> {

    public UserBusiness() {
        super(User.class, new UserRepository());
    }

    @Override
    public void insert(User model) throws Exception {
        this.commonValidations(model);

        //monta o guid...
        model.setAvatarGuid(UUID.randomUUID().toString());

        try {
            super.insert(model);
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro durante a criação do usuário, "
                    + "tente novamente ou contate a equipe responsável.");
        }
    }

    @Override
    public void update(User model) throws Exception {
        this.commonValidations(model);

        if (model.getId() == 0) {
            throw new Exception("Usuário inexistente, verifique.");
        }

        try {
            super.update(model);
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro durante a alteração do usuário, "
                    + "tente novamente ou contate a equipe responsável.");
        }
    }

    private void commonValidations(User model) throws Exception {
        if (model.getName() == null) {
            throw new Exception("Nome não foi informado, verifique.");
        }

        model.setName(model.getName().trim());

        if (model.getName().length() == 0) {
            throw new Exception("Nome não foi informado, verifique.");
        }

        if (model.getLogin() == null) {
            throw new Exception("Login não informado, verifique");
        }

        model.setLogin(model.getLogin().trim());

        if (model.getLogin().length() == 0) {
            throw new Exception("Login não informado, verifique.");
        }

        if (model.getPassword() == null) {
            throw new Exception("Senha não informada, verifique.");
        }

        if (model.getPassword().length() < 6) {
            throw new Exception("A senha deve conter pelo menos 6 caracteres.");
        }

        if (model.getPassword().matches("[\\d]")) {
            throw new Exception("A senha deve conter pelo menos um número.");
        }

        if (model.getPassword().matches("[^\\d]")) {
            throw new Exception("A senha deve conter pelo menos uma letrinha.");
        }

        if (model.getAccessGroup() == null
                || model.getAccessGroup().getId() == 0) {
            throw new Exception("Grupo de acesso não selecionado, verifique.");
        }
    }
}
