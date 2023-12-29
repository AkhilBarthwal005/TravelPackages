package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Destination {
    private String name;
    private List<Activity> activities;

    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

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

    public void bookActivity(List<Passenger> passengers) {
        System.out.println("---------------------------------------------------------------------");
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while (flag){
            System.out.println("Please provide passenger Number for which you want to book activity");
            int passenger_number = sc.nextInt();
            System.out.println("Please provide Activity Number which you want to book");
            int activity_number = sc.nextInt();
            sc.nextLine();
//            Destination destination = getItinerary().stream().findFirst().orElse(null);
//            assert destination != null;
            Activity activity = this.getActivities().stream().filter(a -> a.getId() == activity_number).findFirst().orElse(null);
            Passenger passenger = passengers.stream().filter(p -> p.getNumber() == passenger_number).findFirst().orElse(null);
            assert activity != null;
            flag = activity.bookActivity(flag, activity, passenger);
        }
        System.out.println("---------------------------------------------------------------------");
    }
}
