package Controller;

import exception.ActivityAlreadyExistException;
import model.Destination;
import model.TravelPackage;

import java.util.List;

public class TravelPackageController {

    public TravelPackage createPackage(String name , int capacity , Destination itinerary) throws ActivityAlreadyExistException {
        return TravelPackage.getBuilder().setName(name)
                .setCapacity(capacity)
                .setItinerary(List.of(itinerary))
                .build();
    }

    public void addPassenger(TravelPackage travelPackage){
        travelPackage.addPassenger();
    }

    public void printItinerary(TravelPackage travelPackage){
        travelPackage.printItinerary();
    }

    public void printPassengerList(TravelPackage travelPackage){
        travelPackage.printPassengerList();
    }

    public void printIndividualPassengerDetails(TravelPackage travelPackage){
        travelPackage.printIndividualPassengerDetails();
    }

    public void printAvailableActivities(TravelPackage travelPackage){
        travelPackage.printAvailableActivities();
    }



    public void bookActivity(TravelPackage travelPackage) {
        travelPackage.bookActivity();
    }

    public int getCapacity(TravelPackage travelPackage){
        return travelPackage.getCapacity();
    }
}
