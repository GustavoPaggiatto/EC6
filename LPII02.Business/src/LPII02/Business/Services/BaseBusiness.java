/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import java.util.List;

/**
 *
 * @author Gustavo
 */
public abstract class BaseBusiness<T> {

    protected Class<T> _serviceClass;

    public BaseBusiness(Class<T> serviceClass) {
        this._serviceClass = serviceClass;
    }

    public void insert(T model) {

    }

    public void insert(List<T> models) {

    }

    public void update(T model) {

    }

    public void update(List<T> models) {

    }

    public void delete(T model) {

    }

    public void delete(List<T> models) {

    }

    public T get(int id) {
        return null;
    }

    public List<T> get(int[] ids) {
        return null;
    }
}
