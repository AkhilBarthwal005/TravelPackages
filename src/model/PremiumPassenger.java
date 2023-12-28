package model;

public class PremiumPassenger extends Passenger{


    @Override
    public boolean bookActivity(Activity activity) {
        return false;
    }
}
