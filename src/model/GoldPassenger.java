package model;

import factory.SignupFactory;

import java.util.List;

public class GoldPassenger extends Passenger{

    private double balance;

    public GoldPassenger(String name, int number, double balance) {
        super(name, number);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void signUpForActivity(Activity activity,Passenger passenger) {
        SignupFactory.getSignupActivityByPassengerType(PassengerType.GOLD).signUpForActivity(activity,passenger);
    }

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
    public double getDiscount(Activity activity) {
        return activity.getCost()*0.1; // 10% discount for gold passengers
    }
}
