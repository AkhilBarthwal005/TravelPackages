package strategy;

import model.Activity;
import model.Passenger;
/**
 * An interface defining the strategy for signing up passengers for activities.
 * Implementations of this interface define specific signing-up behavior for different passenger types.
 */
public interface SignupStrategies {
    /**
     * Signs up a passenger for a specific activity based on the implementing strategy.
     *
     * @param activity  The activity to sign up for.
     * @param passenger The passenger signing up for the activity.
     */
    public void signUpForActivity(Activity activity, Passenger passenger);
}
