package strategy;

import model.Activity;
import model.Passenger;

import java.util.List;

public class PremiumPassengerStrategies implements SignupStrategies{
    @Override
    public void signUpForActivity(Activity activity, Passenger passenger) {
        // Check if the activity is not null and the passenger is not already enrolled
        List<Activity> activities = passenger.getActivities();
        if (activity != null && !activities.contains(activity)) {
            // Check if the activity has available space
            if (activity.getCapacity() > 0) {
                // Enroll the passenger in the activity
                activities.add(activity);
                activity.setAvailableSpace(activity.getAvailableSpace() - 1);
                System.out.println("You are our perineum passenger and you can book this activity free of cost");
                System.out.println(passenger.getName() + " has successfully signed up for " + activity.getName());
            } else {
                System.out.println("No available spaces for " + activity.getName());
            }
        } else {
            System.out.println(passenger.getName() + " is already enrolled in " + activity.getName());
        }
    }
}
