package model;

import java.util.Scanner;

/**
 * Represents an activity available in a travel package itinerary.
 * Each activity has a unique identifier, name, description, cost, capacity,
 * available space, and is associated with a specific destination.
 */

public class Activity {

    private int id;
    private Activities name;
    private String description;
    private double cost;
    private int capacity;
    private int availableSpace;
    private Destination destination;

    Scanner sc = new Scanner(System.in);

    /**
     * Constructor to initialize the activity with provided details.
     *
     * @param id           Unique identifier for the activity.
     * @param name         Name of the activity.
     * @param description  Description of the activity.
     * @param cost         Cost of the activity.
     * @param capacity     Maximum capacity for the activity.
     * @param destination  Destination where the activity takes place.
     */

    public Activity(int id,Activities name, String description, double cost, int capacity, Destination destination) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.availableSpace = capacity;
        this.destination = destination;
    }

    // Getters and setters for various attributes...

    public int getId() {
        return id;
    }

    public Activity setId(int id) {
        this.id = id;
        return this;
    }

    public Activities getName() {
        return name;
    }

    public void setName(Activities name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableSpace() {
        return availableSpace;
    }

    public void setAvailableSpace(int availableSpace) {
        this.availableSpace = availableSpace;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    /**
     * Allows a passenger to book the activity and updates the available space.
     *
     * @param flag      Flag indicating whether the booking process should continue.
     * @param activity  The activity to be booked.
     * @param passenger The passenger booking the activity.
     * @return True if the booking process should continue, false otherwise.
     */
    public boolean bookActivity(boolean flag, Activity activity, Passenger passenger) {
        if (passenger == null || activity == null) {
            System.out.println("You have provided an invalid passenger number or invalid activity number");
            System.out.println("---- Please try again -----");
            return flag;
        }

        passenger.signUpForActivity(activity, passenger);
        System.out.println("Do you want to book another activity?");
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("N")) {
            flag = false;
            System.out.println("Thanks for booking with us. Have a happy activity! :) Thank you");
        }
        return flag;
    }
}
