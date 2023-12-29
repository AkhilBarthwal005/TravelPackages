package strategy;

import model.Activity;
import model.GoldPassenger;
import model.Passenger;

import java.util.List;

public class GoldPassengerStrategies implements SignupStrategies{
    @Override
    public void signUpForActivity(Activity activity, Passenger passenger) {
        // Check if the activity is not null and the passenger is not already enrolled
        List<Activity> activities = passenger.getActivities();
        if (activity != null && !activities.contains(activity)) {
            // Check if the activity has available space
            if (activity.getCapacity() > 0) {
                // Check if the passenger has sufficient balance
                GoldPassenger goldPassenger = (GoldPassenger) passenger;
                if ( (goldPassenger.getBalance() >= activity.getCost() - goldPassenger.getDiscount(activity))) {
                    // Enroll the passenger in the activity
                    activities.add(activity);
                    activity.setAvailableSpace(activity.getAvailableSpace() - 1);
                    // Deduct the cost from the balance if applicable
                    goldPassenger.setBalance(goldPassenger.getBalance() - (activity.getCost() - goldPassenger.getDiscount(activity)));
                    System.out.println("10% discount applied for our valuable Gold passenger " + goldPassenger.getDiscount(activity));
                    System.out.println(passenger.getName() + " has successfully signed up for " + activity.getName());
                } else {
                    System.out.println("Insufficient balance for " + passenger.getName() + " to sign up for " + activity.getName());
                }
            } else {
                System.out.println("No available spaces for " + activity.getName());
            }
        } else {
            System.out.println(passenger.getName() + " is already enrolled in " + activity.getName());
        }

    }
}
