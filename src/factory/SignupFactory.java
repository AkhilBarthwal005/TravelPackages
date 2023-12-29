package factory;

import model.PassengerType;
import strategy.GoldPassengerStrategies;
import strategy.PremiumPassengerStrategies;
import strategy.SignupStrategies;
import strategy.StandardPassengerStrategies;

public class SignupFactory {
    public static SignupStrategies getSignupActivityByPassengerType(PassengerType passengerType){
        return switch (passengerType){
            case PREMIUM -> new PremiumPassengerStrategies();
            case GOLD -> new GoldPassengerStrategies();
            case STANDARD -> new StandardPassengerStrategies();
        };
    }
}
