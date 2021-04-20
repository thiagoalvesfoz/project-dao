package com.monfauna;

import com.monfauna.dao.LocationDao;
import com.monfauna.dao.UserDao;
import com.monfauna.model.Location;
import com.monfauna.model.Owner;
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

        //Salvar usuario
        //Dados de entrada
        Owner owner = new Owner();
        owner.setName("Naz");
        owner.setEmail("nazarew@gmail.com");
        owner.setPassword("kolachaqua45");
        owner.setAdmin(true);
        //Processamento/persistencia do dado
        Owner userSaved = (Owner)userDao.save(owner);
        System.out.println("Usuario salvo= " + userSaved);


        LocationDao locationDao = DaoFactory.getLocationDao();
        List<Location> locations = locationDao.findAll();
        for ( Location l : locations){
            System.out.println(l);
        }

        System.out.println("search location by id");
        Location location = locationDao.findById(5);
        System.out.println(location);


    }
}
/*
// 1º primeiro - Cria interface LocationDao
// 2º - no pacote impl- crie LocationDatoImpl
3º - em DaoFactory, crie um método static que retorne uma instância de LocationDao
 */
