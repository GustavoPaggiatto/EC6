/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Domain.Entities;

import java.util.List;

/**
 *
 * @author Gustavo
 */
public class Teacher extends User {

    protected List<Matter> _matters;
    protected String _lastDegree;
    protected String _expecialization;

    public List<Matter> getMatters() {
        return this._matters;
    }

    public void setMatters(List<Matter> matters) {
        this._matters = matters;
    }

    public String getLastDegree() {
        return _lastDegree;
    }

    public void setLastDegree(String _lastDegree) {
        this._lastDegree = _lastDegree;
    }

    public String getExpecialization() {
        return this._expecialization;
    }

    public void setExpecialization(String expecialization) {
        this._expecialization = expecialization;
    }
}
