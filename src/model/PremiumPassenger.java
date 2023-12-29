package model;

import factory.SignupFactory;

/**
 * A class representing a premium passenger in the travel package booking system.
 * Premium passengers have a name, number, and can sign up for activities for free.
 */

public class PremiumPassenger extends Passenger{

    /**
     * Constructor to initialize a premium passenger with a name and number.
     *
     * @param name   Name of the premium passenger.
     * @param number Passenger number.
     */

    public PremiumPassenger(String name, int number) {
        super(name, number);
    }

    /**
     * Method to sign up a premium passenger for an activity.
     *
     * @param activity  Activity to sign up for.
     * @param passenger Passenger signing up for the activity.
     */
    @Override
    public void signUpForActivity(Activity activity,Passenger passenger) {
      SignupFactory.getSignupActivityByPassengerType(PassengerType.PREMIUM).signUpForActivity(activity,passenger);
    }

    /**
     * Method to print details of a premium passenger, including the activities they have enrolled in.
     */
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
