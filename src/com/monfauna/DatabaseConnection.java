package com.monfauna;

import com.monfauna.dao.UserDao;
import com.monfauna.model.User;
import com.monfauna.dao.impl.DaoFactory;

import java.util.List;

public class DatabaseConnection {

    public static void main(String[] args) {

// Listando todos os usuarios
        UserDao userDao = DaoFactory.getUserDao();
        List<User> users = userDao.findAll();
        for (User u : users) {
            System.out.println(u);
        }
        //Buscar usuario pelo id
        System.out.println("Search user by id");
        User user = userDao.findById(2);
        System.out.println(user);



    }
}
