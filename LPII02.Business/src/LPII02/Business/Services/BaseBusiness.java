/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Dal.Repositories.BaseRepository;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public abstract class BaseBusiness<T> {

    protected Class<T> _serviceClass;
    protected BaseRepository<T> _repository;

    public BaseBusiness(Class<T> serviceClass) {
        this._serviceClass = serviceClass;
    }

    public BaseBusiness(Class<T> serviceClass, BaseRepository repository) {
        this._serviceClass = serviceClass;
        this._repository = repository;
    }

    public T getInstance() throws InstantiationException, IllegalAccessException {
        return this._serviceClass.newInstance();
    }

    public void insert(T model) throws Exception {
        this._repository.insert(model, true);
    }

    public void insert(List<T> models) {
        this._repository.insert(models, true);
    }

    public void update(T model) throws Exception {
        this._repository.update(model, true);
    }

    public void update(List<T> models) {
        this._repository.update(models, true);
    }

    public void delete(T model) {
        this._repository.delete(model, true);
    }

    public void delete(List<T> models) {
        this._repository.delete(models, true);
    }

    public T get(int id) {
        return this._repository.get(id);
    }

    public List<T> get(int[] ids) {
        return this._repository.get(ids);
    }

    public List<T> get() {
        return this._repository.get();
    }
}
