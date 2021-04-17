/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Dal.Repositories;

import LPII02.Domain.Entities.User;

/**
 *
 * @author Gustavo
 */
public class UserRepository extends BaseRepository<User> {

    public UserRepository() {
        super(User.class);
    }

}
