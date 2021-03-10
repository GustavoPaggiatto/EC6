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
public class User extends BaseEntity {

    protected String _name;
    protected String _login;
    protected String _password;
    protected byte[] _avatar;

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public byte[] getAvatar() {
        return _avatar;
    }

    public void setAvatar(byte[] _avatar) {
        this._avatar = _avatar;
    }
}
