package model;

import factory.SignupFactory;


/**
 * Represents a Gold passenger in the travel package booking system.
 * Gold passengers have a balance and receive a 10% discount on activity costs.
 */

public class GoldPassenger extends Passenger{

    private double balance;

    /**
     * Constructor to initialize a Gold passenger with a name, number, and balance.
     *
     * @param name    Name of the Gold passenger.
     * @param number  Passenger number.
     * @param balance Initial balance of the Gold passenger.
     */

    public GoldPassenger(String name, int number, double balance) {
        super(name, number);
        this.balance = balance;
    }

    // Getter and setter for balance...

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    /**
     * Overrides the method to sign up for an activity with Gold passenger-specific behavior.
     *
     * @param activity  Activity to sign up for.
     * @param passenger Passenger signing up for the activity.
     */
    @Override
    public void signUpForActivity(Activity activity,Passenger passenger) {
        SignupFactory.getSignupActivityByPassengerType(PassengerType.GOLD).signUpForActivity(activity,passenger);
    }

    /**
     * Overrides the method to print details specific to Gold passengers.
     */
    @Override
    public void printPassengerDetails() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Passenger Name - " + getName());
        System.out.println("Passenger Number - " + getNumber());
        System.out.println("Passenger available Balance - " + getBalance());
        System.out.println("Passenger Category - " + PassengerType.GOLD);
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

    /**
     * Calculates and returns the discount amount for Gold passengers.
     *
     * @param activity Activity for which the discount is calculated.
     * @return Discount amount.
     */
    public double getDiscount(Activity activity) {
        return activity.getCost()*0.1; // 10% discount for gold passengers
    }
}
