package LPII02.Domain.Entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Gustavo
 */
public abstract class BaseEntity {

    protected int _id;

    public void setId(int id) {
        this._id = id;
    }

    public int getId() {
        return this._id;
    }
}
