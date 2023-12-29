package model;

import java.util.List;
import java.util.Scanner;

public class Activity {

    private int id;
    private Activities name;
    private String description;
    private double cost;
    private int capacity;
    private int availableSpace;
    private Destination destination;

    Scanner sc = new Scanner(System.in);

    public Activity(int id,Activities name, String description, double cost, int capacity, Destination destination) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.availableSpace = capacity;
        this.destination = destination;
    }

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

    public  boolean bookActivity(boolean flag, Activity activity, Passenger passenger) {
        if(passenger == null || activity == null){
            System.out.println("you have provide a invalid passenger number or Invalid Activity number");
            System.out.println("---- Please try again -----");
            return flag;
        }

        passenger.signUpForActivity(activity,passenger);
        System.out.println("Do you want to book another Activity");
        String input = sc.nextLine();
        if(input.equalsIgnoreCase("N")){
            flag = false;
            System.out.println("Thanks for booking with us have a Happy Activity :) Thank you");
        }
        return flag;
    }
}
