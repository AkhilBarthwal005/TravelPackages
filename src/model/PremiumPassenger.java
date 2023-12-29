package model;

import factory.SignupFactory;

import java.util.List;

public class PremiumPassenger extends Passenger{


    public PremiumPassenger(String name, int number) {
        super(name, number);
    }

    // Method to sign up for an activity
    @Override
    public void signUpForActivity(Activity activity,Passenger passenger) {
      SignupFactory.getSignupActivityByPassengerType(PassengerType.PREMIUM).signUpForActivity(activity,passenger);
    }

    @Override
    public void printPassengerDetails() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Passenger Name - " + getName());
        System.out.println("Passenger Number - " + getNumber());
        System.out.println("Passenger Category - " + PassengerType.PREMIUM);
        System.out.println("List of activity in which you enrolled");
        for (Activity activity:
             getActivities()) {
            System.out.println("**********************************************************");
            System.out.println("Activity Name - ||  " + activity.getName());
            System.out.println("Activity Destination - ||   " + activity.getDestination().getName());
            System.out.println("Activity price you paid - ||    " + activity.getCost());
        }
        System.out.println("---------------------------------------------------------------------");
    }
}
