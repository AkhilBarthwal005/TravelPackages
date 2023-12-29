package model;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract class representing a passenger in the travel package booking system.
 * Each passenger has a name, number, and a list of activities they have signed up for.
 */

public abstract class Passenger {
    private String name;
    private int number;
    private List<Activity> activities;

    /**
     * Constructor to initialize a passenger with a name and number.
     *
     * @param name   Name of the passenger.
     * @param number Passenger number.
     */
    public Passenger(String name, int number) {
        this.name = name;
        this.number = number;
        activities = new ArrayList<>();
    }

    // Getter and setter methods for name, number, and activities...


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }


    /**
     * Abstract method to be implemented by subclasses for signing up a passenger for an activity.
     *
     * @param activity  Activity to sign up for.
     * @param passenger Passenger signing up for the activity.
     */

    public abstract void signUpForActivity(Activity activity,Passenger passenger);

    /**
     * Abstract method to be implemented by subclasses for printing details specific to each passenger type.
     */

    public abstract void printPassengerDetails();
}
