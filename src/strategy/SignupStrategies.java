package strategy;

import model.Activity;
import model.Passenger;

public interface SignupStrategies {
    public void signUpForActivity(Activity activity, Passenger passenger);
}
