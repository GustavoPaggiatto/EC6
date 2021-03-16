/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Dal.Repositories;

import LPII02.Domain.Entities.Matter;

/**
 *
 * @author Gustavo
 */
public class MatterRepository extends BaseRepository<Matter> {

    public MatterRepository() {
        super(Matter.class);
    }
}
