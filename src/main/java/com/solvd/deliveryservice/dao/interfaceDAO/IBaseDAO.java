package com.solvd.deliveryservice.dao.interfaceDAO;


public interface IBaseDAO<T> {

    T findById(int id) throws Exception;
    void insert(T entity) throws Exception;
    void update(T entity) throws Exception;
    void delete(int id) throws Exception;


}
