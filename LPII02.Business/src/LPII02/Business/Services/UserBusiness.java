/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Dal.Repositories.UserRepository;
import LPII02.Domain.Entities.User;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
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

    public void login(User user) throws Exception {
        if (user.getLogin() == null) {
            throw new Exception("Login não informado!");
        }

        user.setLogin(user.getLogin().trim());

        if (user.getLogin().length() == 0) {
            throw new Exception("Login não informado!");
        }

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest = md.digest(user.getPassword().getBytes(StandardCharsets.UTF_8));
        String senhahex = bytesToHex(messageDigest);

        try {
            User result = ((UserRepository) this._repository).login(user.getLogin(), senhahex);

            if (result == null) {
                throw new Exception("Usuário/senha inválidos, tente novamente.");
            }
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro na base de dados ao autenticar o usuário, "
                    + "tente novamente ou contate a equipe responsável.");
        }
    }

    public void register(User user, String confirmPasswd) throws Exception {
        if (user.getLogin() == null) {
            throw new Exception("Login não informado!");
        }

        user.setLogin(user.getLogin().trim());

        if (user.getLogin().length() == 0) {
            throw new Exception("Login não informado!");
        }

        if (!user.getPassword().equals(confirmPasswd)) {
            throw new Exception("Confirmação da senha não confere com a senha informada!");
        }
    }

    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
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
