package com.monfauna;

import com.monfauna.dao.LocationDao;
import com.monfauna.dao.UserDao;
import com.monfauna.model.Location;
import com.monfauna.model.Owner;
import com.monfauna.model.User;
import com.monfauna.dao.impl.DaoFactory;

import java.time.LocalDateTime;
import java.util.List;

public class UserTest {

    public static void main(String[] args) {

// List all users
        System.out.println("\n###############");
        UserDao userDao = DaoFactory.getUserDao();
        List<User> users = userDao.findAll();
        for (User u : users) {
            System.out.println(u);
        }
        //Search user by id
        System.out.println("\n###############");
        System.out.println("Search user by id");
        User user = userDao.findById(2);
        System.out.println(user);

        //Save user
        //Dados de entrada
        System.out.println("\n###############");
        User owner = new Owner();
        owner.setName("Naz");
        owner.setEmail("nazarew@gmail.com");
        owner.setPassword("kolachaqua45");
        owner.setAdmin(true);
        //Processamento/persistencia do dado
        User userSaved = userDao.save(owner);
        System.out.println("Usuario salvo= " + userSaved);

        //Update user
        System.out.println("\n############### UPDATE");
        User userToUpdate = userDao.findById(userSaved.getId());
        userToUpdate.setName("Pam");
        userToUpdate.setEmail("tammyhrah@gmail.com");
        userToUpdate.setPassword("kakarotsvag55");
        userToUpdate.setAdmin(false);
        userToUpdate.setUpdatedAt(LocalDateTime.now());
        userDao.update(userToUpdate);
        List<User> userList = userDao.findAll();
        for (User u : userList) {
            System.out.println(u);
        }


        //Remove user
        System.out.println("\n###############");
        userDao.deleteById(userSaved.getId());
        User userDeleted = userDao.findById(userSaved.getId());
        if (userDeleted==null){
            System.out.println("Usuario removido com sucesso");
        }

        System.out.println("\n###############");
        LocationDao locationDao = DaoFactory.getLocationDao();
        List<Location> locations = locationDao.findAll();
        for ( Location l : locations){
            System.out.println(l);
        }

        System.out.println("\n###############");
        System.out.println("search location by id");
        Location location = locationDao.findById(5);
        System.out.println(location);

        //Save location
        //Dados de entrada
        System.out.println("\n###############");
        Location locationToSave = new Location();
        locationToSave.setName("modulo 6");
        locationToSave.setLatitude("-25.564803");
        locationToSave.setLongitude("-54.5639094");
        //Processamento/persistencia do dado
        System.out.println("location: " + locationToSave);
        locationToSave = locationDao.save(locationToSave);
        System.out.println("Location saved= " + locationToSave);


        System.out.println("\n############### UPDATE");
        Location locationToUpdate = locationDao.findById(locationToSave.getId());
        locationToUpdate.setName("modulo 6 updated");
        locationToUpdate.setLatitude("-25.584634");
        locationToUpdate.setLongitude("-54.7245696");
        locationDao.update(locationToUpdate);
        List<Location> locationList = locationDao.findAll();
        for (Location l : locationList) {
            System.out.println(l);
        }

        //Remove location
        System.out.println("\n###############");
        locationDao.deleteById(locationToUpdate.getId());
        Location locationDeleted = locationDao.findById(locationToUpdate.getId());
        if (locationDeleted==null){
            System.out.println("location removed successfully");
        }

    }
}
/*
// 1º primeiro - Cria interface LocationDao
// 2º - no pacote impl- crie LocationDatoImpl
3º - em DaoFactory, crie um método static que retorne uma instância de LocationDao
 */
