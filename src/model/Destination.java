package model;

import exception.InvalidActivityNumberException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a destination in a travel package itinerary.
 * Each destination has a name and a list of activities available at that destination.
 */

public class Destination {
    private String name;
    private List<Activity> activities;

    /**
     * Constructor to initialize the destination with a name.
     *
     * @param name Name of the destination.
     */
    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    // Getters and setters for various attributes...

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    /**
     * Prints details of activities with available spaces at this destination.
     */

    public void printAvailableActivities() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("------Here are the details of activities with available spaces-------");
        System.out.println("Destination Name - " + this.getName());
        List<Activity> availableActivities = this.getActivities().stream()
                .filter(activity -> activity.getCapacity() > 0).toList();
        availableActivities.forEach(activity -> {
            System.out.println("**********************************************************");
            System.out.println("  Activity Name - ||    " + activity.getName());
            System.out.println("  Cost - || " + activity.getCost());
            System.out.println("  Capacity - || " + activity.getCapacity());
            System.out.println("  Available Spaces - || " + activity.getAvailableSpace());
            System.out.println("  Description - ||  " + activity.getDescription());
        });
        System.out.println("---------------------------------------------------------------------");
    }

    /**
     * Allows booking activities for passengers at this destination.
     *
     * @param passengers List of passengers for whom activities are booked.
     */

    public void bookActivity(List<Passenger> passengers) throws InvalidActivityNumberException {
        System.out.println("---------------------------------------------------------------------");
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while (flag){
            System.out.println("Please provide passenger Number for which you want to book activity");
            int passenger_number = sc.nextInt();
            System.out.println("Please provide Activity Number which you want to book");
            int activity_number = sc.nextInt();
            sc.nextLine();// to handle extra space which come in the form of enter when user try to input details from console
            Activity activity = this.getActivities().stream().filter(a -> a.getId() == activity_number).findFirst().orElse(null);
            Passenger passenger = passengers.stream().filter(p -> p.getNumber() == passenger_number).findFirst().orElse(null);
            if(activity == null){
                throw new InvalidActivityNumberException("Please provide correct activity id");
            }
            flag = activity.bookActivity(flag, activity, passenger);
        }
        System.out.println("---------------------------------------------------------------------");
    }
}
