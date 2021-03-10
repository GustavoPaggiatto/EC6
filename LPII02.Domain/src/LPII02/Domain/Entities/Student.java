/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Domain.Entities;

/**
 *
 * @author Gustavo
 */
public class Student extends User {

    protected String _graduation;

    public String getGraduation() {
        return _graduation;
    }

    public void setGraduation(String graduation) {
        this._graduation = graduation;
    }
}
