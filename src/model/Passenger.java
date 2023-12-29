package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Passenger {
    private String name;
    private int number;
    private List<Activity> activities;

    public Passenger(String name, int number) {
        this.name = name;
        this.number = number;
        activities = new ArrayList<>();
    }

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

    public abstract void signUpForActivity(Activity activity,Passenger passenger);

    public abstract void printPassengerDetails();
}
