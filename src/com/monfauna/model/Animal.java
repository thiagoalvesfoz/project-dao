package com.monfauna.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Animal {

    private Integer id;
    private String scientificName;
    private String commonName;
    private String number;
    private char sex;
    private String imageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDate registerDate;
    private Location location;
    private List<AnimalMeasurement> measurements = new ArrayList<>();

    public Animal(){

    }

    public Animal(Integer id, String scientificName, String commonName, String number, char sex, String imageUrl, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDate registerDate, Location location) {
        this.id = id;
        this.scientificName = scientificName;
        this.commonName = commonName;
        this.number = number;
        this.sex = sex;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.registerDate = registerDate;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<AnimalMeasurement> getMeasurements() {
        return measurements;
    }

    public void addMeasurement(String length, String width, String height, String weight, String description){
        AnimalMeasurement animalMeasurement = new AnimalMeasurement();
        animalMeasurement.setHeight(height);
        animalMeasurement.setLength(length);
        animalMeasurement.setWidth(width);
        animalMeasurement.setWeight(weight);
        animalMeasurement.setDescription(description);

        this.measurements.add(animalMeasurement);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", scientificName='" + scientificName + '\'' +
                ", commonName='" + commonName + '\'' +
                ", number='" + number + '\'' +
                ", sex=" + sex +
                ", imageUrl='" + imageUrl + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", registerDate=" + registerDate +
                ", location=" + location +
                ", measurements=" + measurements +
                '}';
    }
}
