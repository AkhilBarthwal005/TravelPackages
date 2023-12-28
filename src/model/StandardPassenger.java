package model;

public class StandardPassenger extends Passenger{

    private double balance;

    @Override
    public boolean bookActivity(Activity activity) {
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
