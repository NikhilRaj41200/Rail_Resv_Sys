package com.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Railway {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    private static final String USER_USERNAME = "user";
    private static final String USER_PASSWORD = "user123";

    private static List<Train> trainDatabase = new ArrayList<>();
    private static List<User> userList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Railway Reservation System!");
        System.out.println("Select mode:");
        System.out.println("1. Admin");
        System.out.println("2. User");

        int mode = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        if (mode == 1) {
            adminMode(username, password, scanner);
        } else if (mode == 2) {
            userMode(username, password);
        } else {
            System.out.println("Invalid mode selection.");
        }

        scanner.close();
    }

    public static void adminMode(String username, String password, Scanner scanner) {
        if (authenticateAdmin(username, password)) {
            System.out.println("Admin logged in successfully.");

            int choice;
            do {
                System.out.println("\nAdmin Menu:");
                System.out.println("1. Create detail database of trains");
                System.out.println("2. Add Details of trains");
                System.out.println("3. Display all the database of trains");
                System.out.println("4. Display Chart of a train");
                System.out.println("5. Display all users");
                System.out.println("6. Update train date");
                System.out.println("7. Return to main menu");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        createTrainDatabase(scanner);
                        break;
                    case 2:
                        addTrainDetails(scanner);
                        break;
                    case 3:
                        displayAllTrains();
                        break;
                    case 4:
                        displayTrainChart(scanner);
                        break;
                    case 5:
                        displayAllUsers();
                        break;
                    case 6:
                        updateTrainDate(scanner);
                        break;
                    case 7:
                        return;
                    case 8:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 7);
        } else {
            System.out.println("Invalid admin credentials.");
        }
    }

    private static boolean authenticateAdmin(String username, String password) {
        return username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);
    }

    private static void createTrainDatabase(Scanner scanner) {
        System.out.println("Enter train number:");
        String trainNumber = scanner.nextLine();
        System.out.println("Enter train name:");
        String trainName = scanner.nextLine();
        System.out.println("Enter boarding station:");
        String boardingStation = scanner.nextLine();
        System.out.println("Enter destination station:");
        String destinationStation = scanner.nextLine();
        System.out.println("Enter departure time:");
        String departureTime = scanner.nextLine();
        System.out.println("Enter arrival time:");
        String arrivalTime = scanner.nextLine();
        System.out.println("Enter train type:");
        String trainType = scanner.nextLine();

        // Create a new Train object with the provided details
        Train train = new Train(trainNumber, trainName, boardingStation, destinationStation, departureTime, arrivalTime, trainType);

        // Add the new train to the train database
        trainDatabase.add(train);

        System.out.println("Train details added successfully.");
    }

    private static void addTrainDetails(Scanner scanner) {
        // Implement if needed
    }

    static void displayAllTrains() {
        System.out.println("Train Database:");
        for (Train train : trainDatabase) {
            System.out.println(train);
        }
    }

    private static void displayTrainChart(Scanner scanner) {
        System.out.println("Enter train number to display chart:");
        String trainNumber = scanner.nextLine();

        // Find the train with the given train number
        Train selectedTrain = null;
        for (Train train : trainDatabase) {
            if (train.getTrainNumber().equalsIgnoreCase(trainNumber)) {
                selectedTrain = train;
                break;
            }
        }

        if (selectedTrain != null) {
            // Display the train chart
            System.out.println("Train Chart for Train Number: " + trainNumber);
            System.out.println("Train Name: " + selectedTrain.getTrainName());
            System.out.println("Departure Time: " + selectedTrain.getDepartureTime());
            System.out.println("Arrival Time: " + selectedTrain.getArrivalTime());
            System.out.println("Boarding Station: " + selectedTrain.getBoardingStation());
            System.out.println("Destination Station: " + selectedTrain.getDestinationStation());
            // Add more details as needed
        } else {
            System.out.println("Train with number " + trainNumber + " not found.");
        }
    }

    private static void displayAllUsers() {
        // Assuming you have a list of users called userList
        System.out.println("All Users:");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    private static void updateTrainDate(Scanner scanner) {
        System.out.println("Enter train number to update:");
        String trainNumber = scanner.nextLine();

        // Find the train with the given train number
        Train selectedTrain = null;
        for (Train train : trainDatabase) {
            if (train.getTrainNumber().equalsIgnoreCase(trainNumber)) {
                selectedTrain = train;
                break;
            }
        }

        if (selectedTrain != null) {
            System.out.println("Enter new departure time:");
            String newDepartureTime = scanner.nextLine();
            selectedTrain.setDepartureTime(newDepartureTime);

            System.out.println("Enter new arrival time:");
            String newArrivalTime = scanner.nextLine();
            selectedTrain.setArrivalTime(newArrivalTime);

            System.out.println("Train details updated successfully.");
        } else {
            System.out.println("Train with number " + trainNumber + " not found.");
        }
    }

    public static void userMode(String username, String password) {
        // Implement if needed
    }

    public static void bookTicket(User user, Scanner scanner) {
        // Display available trains
        displayAllTrains();

        // Prompt user to select a train
        System.out.println("Enter train number to book ticket:");
        String trainNumber = scanner.nextLine();

        // Find the selected train
        Train selectedTrain = null;
        for (Train train : trainDatabase) {
            if (train.getTrainNumber().equalsIgnoreCase(trainNumber)) {
                selectedTrain = train;
                break;
            }
        }

        if (selectedTrain != null) {
            // Gather necessary information from the user
            System.out.println("Enter number of tickets:");
            int numberOfTickets = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            // Create a new ticket and add it to the train
            Ticket ticket = new Ticket(selectedTrain, user, numberOfTickets);
            selectedTrain.getTickets().add(ticket);

            System.out.println("Ticket booked successfully.");
        } else {
            System.out.println("Train with number " + trainNumber + " not found.");
        }
    }

	public static boolean bookTicket(String trainNumber, User user, int numberOfTickets) {
		// TODO Auto-generated method stub
		return false;
	}
}
