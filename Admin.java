package com.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "admin_table")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Train> trains;

    // Constructors, getters, and setters

    public Admin() {
        trains = new ArrayList<>();
    }

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        trains = new ArrayList<>();
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    // Method to add train details
    public void addTrain(String trainNumber, String trainName, String boardingStation, String destinationStation, String departureTime, String arrivalTime, String trainType) {
        Train train = new Train(trainNumber, trainName, boardingStation, destinationStation, departureTime, arrivalTime, trainType);
        train.setAdmin(this); // Set the admin for bidirectional association
        trains.add(train);
        System.out.println("Train added successfully.");
        //Method to get all trains details
        
        
    }

    // Method to display admin information
    public void displayInfo() {
        System.out.println("Admin username: " + username);
        // Display other admin information if needed
    }
}
