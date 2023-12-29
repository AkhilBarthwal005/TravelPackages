package factory;

import model.PassengerType;
import strategy.GoldPassengerStrategies;
import strategy.PremiumPassengerStrategies;
import strategy.SignupStrategies;
import strategy.StandardPassengerStrategies;

/**
 * Factory class responsible for creating SignupStrategies based on PassengerType.
 * It provides a method to get the appropriate SignupStrategies for a given PassengerType.
 */
public class SignupFactory {

    /**
     * Gets the SignupStrategies based on the provided PassengerType.
     *
     * @param passengerType The type of the passenger (PREMIUM, GOLD, STANDARD)
     * @return An instance of SignupStrategies suitable for the specified PassengerType.
     */
    public static SignupStrategies getSignupActivityByPassengerType(PassengerType passengerType) {
        return switch (passengerType) {
            case PREMIUM -> new PremiumPassengerStrategies();
            case GOLD -> new GoldPassengerStrategies();
            case STANDARD -> new StandardPassengerStrategies();
        };
    }
}
