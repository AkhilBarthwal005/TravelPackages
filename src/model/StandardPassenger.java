package model;

import factory.SignupFactory;

/**
 * A class representing a standard passenger in the travel package booking system.
 * Standard passengers have a name, number, and a balance to pay for activities.
 */

public class StandardPassenger extends Passenger{

    // Balance of the standard passenger
    private double balance;

    /**
     * Constructor to initialize a standard passenger with a name, number, and balance.
     *
     * @param name    Name of the standard passenger.
     * @param number  Passenger number.
     * @param balance Initial balance of the standard passenger.
     */
    public StandardPassenger(String name, int number, double balance) {
        super(name,number);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Method to sign up a standard passenger for an activity.
     *
     * @param activity  Activity to sign up for.
     * @param passenger Passenger signing up for the activity.
     */

    @Override
    public void signUpForActivity(Activity activity,Passenger passenger) {
        SignupFactory.getSignupActivityByPassengerType(PassengerType.STANDARD).signUpForActivity(activity,passenger);
    }

    /**
     * Method to print details of a standard passenger, including the activities they have enrolled in.
     */
    @Override
    public void printPassengerDetails() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Passenger Name - " + getName());
        System.out.println("Passenger Number - " + getNumber());
        System.out.println("Passenger available Balance - " + getBalance());
        System.out.println("Passenger Category - " + PassengerType.STANDARD);
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
