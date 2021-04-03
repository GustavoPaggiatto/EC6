/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Dal.Repositories.AlternativeRepository;
import LPII02.Domain.Entities.Alternative;

/**
 *
 * @author Gustavo
 */
public class AlternativeBusiness extends BaseBusiness<Alternative> {

    public AlternativeBusiness() {
        super(Alternative.class, new AlternativeRepository());
    }
}
