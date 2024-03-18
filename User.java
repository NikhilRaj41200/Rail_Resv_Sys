package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Scanner;

@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    // Constructors
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 // Method to display user information
    public void displayInfo() {
        System.out.println("User username: " + username);
        // Display other admin information if needed
        
     // Method to book a ticket
        public void bookTicket(Scanner scanner) {
            System.out.println("Booking Ticket:");
            System.out.println("Select train from the available trains:");
            Railway.displayAllTrains();

            System.out.print("Enter train number: ");
            String trainNumber = scanner.nextLine();

            System.out.print("Enter number of tickets: ");
            int numberOfTickets = Integer.parseInt(scanner.nextLine());

            // Call the method in Railway class to book the ticket
            boolean ticketBooked = Railway.bookTicket(trainNumber, this, numberOfTickets);

            if (ticketBooked) {
                System.out.println("Ticket(s) booked successfully!");
            } else {
                System.out.println("Failed to book ticket(s). Please try again.");
            }
        }

    }
}
