package com.monfauna;

import com.monfauna.dao.UserDao;
import com.monfauna.model.User;
import com.monfauna.dao.impl.DaoFactory;

import java.util.List;

public class DatabaseConnection {

    public static void main(String[] args) {


        UserDao userDao = DaoFactory.getUserDao();
        List<User> users = userDao.findAll();
        for (User u : users) {
            System.out.println(u);
        }


    }
}
