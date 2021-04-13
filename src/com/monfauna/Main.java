package com.monfauna;

import com.monfauna.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        Owner owner = new Owner();
        owner.setName("Ham");
        owner.setEmail("breadwithham@gmail.com");
        owner.setPassword("jacurahamma");
        owner.setAdmin(true);

        Collaborator collaborator = new Collaborator();
        collaborator.setName("Bon");
        collaborator.setEmail("Bonnaparte2@gmail.com");
        collaborator.setPassword("folagiaers34");

        Location location = new Location();
        location.setName("America do sul");
        location.setLatitude("34657354");
        location.setLongitude("09876542133");

        // uma forma de evitar os setters é adicionando um construtor com parâmetros
        Animal animal = new Animal(
                null,
                "",
                "",
                "",
                'F',
                "",
                LocalDateTime.now(),
                LocalDateTime.now(),
                LocalDate.now(),
                location
        );
        animal.addMeasurement("", "", "", "", "");

        Project project = new Project();
        project.setName("Jurassic Park");
        project.setOwner(owner);
        project.getCollaborators().add(collaborator);
        project.getAnimals().add(animal);
        System.out.println(project);


    }
}
