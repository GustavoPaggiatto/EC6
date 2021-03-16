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
}
