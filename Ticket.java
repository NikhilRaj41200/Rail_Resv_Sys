package com.example.model;


import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int numberOfTickets;

    // Constructors, getters, and setters

    public Ticket() {
    }

    public Ticket(Train train, User user, int numberOfTickets) {
        this.train = train;
        this.user = user;
        this.numberOfTickets = numberOfTickets;
    }

    // Getters and setters
    // Ensure getters and setters are present for all fields

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", train=" + train +
                ", user=" + user +
                ", numberOfTickets=" + numberOfTickets +
                '}';
    }
}
