package com.monfauna.dao;

import com.monfauna.model.Owner;
import com.monfauna.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //crud: create read update delete

    User save(User user);
    List<User> findAll();
    User findById(Integer id);
    User update(User user);
    void deleteById(Integer id);
}
