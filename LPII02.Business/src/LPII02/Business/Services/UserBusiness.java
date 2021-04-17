/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Dal.Repositories.UserRepository;
import LPII02.Domain.Entities.User;

/**
 *
 * @author Gustavo
 */
public class UserBusiness extends BaseBusiness<User> {

    public UserBusiness() {
        super(User.class, new UserRepository());
    }

}
