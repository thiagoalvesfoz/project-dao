package com.monfauna.dao;

import com.monfauna.model.User;

import java.util.List;

public interface Crud<T> {
    T save(T user);
    List<T> findAll();
    T findById(Integer id);
    T update(T user);
    void deleteById(Integer id);
}
