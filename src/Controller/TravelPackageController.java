package Controller;

import exception.ActivityAlreadyExistException;
import model.Destination;
import model.TravelPackage;

import java.util.List;

/**
 * The TravelPackageController class handles the interaction between the client and the TravelPackage model.
 * It provides methods to create packages, add passengers, and perform various operations related to the travel package.
 */
public class TravelPackageController {

    /**
     * Creates a new TravelPackage with the specified name, capacity, and itinerary.
     *
     * @param name      The name of the travel package.
     * @param capacity  The passenger capacity of the travel package.
     * @param itinerary The list of destinations in the travel package.
     * @return A newly created TravelPackage.
     * @throws ActivityAlreadyExistException if an activity with the same name already exists.
     */
    public TravelPackage createPackage(String name, int capacity, Destination itinerary) throws ActivityAlreadyExistException {
        return TravelPackage.getBuilder().setName(name)
                .setCapacity(capacity)
                .setItinerary(List.of(itinerary))
                .build();
    }

    /**
     * Adds a passenger to the specified travel package.
     *
     * @param travelPackage The travel package to which the passenger will be added.
     */
    public void addPassenger(TravelPackage travelPackage) {
        travelPackage.addPassenger();
    }

    /**
     * Prints the itinerary of the specified travel package, including destinations and activities.
     *
     * @param travelPackage The travel package whose itinerary will be printed.
     */
    public void printItinerary(TravelPackage travelPackage) {
        travelPackage.printItinerary();
    }

    /**
     * Prints the list of passengers in the specified travel package.
     *
     * @param travelPackage The travel package whose passenger list will be printed.
     */
    public void printPassengerList(TravelPackage travelPackage) {
        travelPackage.printPassengerList();
    }

    /**
     * Prints the details of an individual passenger in the specified travel package.
     *
     * @param travelPackage The travel package containing the passenger.
     */
    public void printIndividualPassengerDetails(TravelPackage travelPackage) {
        travelPackage.printIndividualPassengerDetails();
    }

    /**
     * Prints the details of activities that still have spaces available in the specified travel package.
     *
     * @param travelPackage The travel package whose available activities will be printed.
     */
    public void printAvailableActivities(TravelPackage travelPackage) {
        travelPackage.printAvailableActivities();
    }

    /**
     * Initiates the process of booking an activity in the specified travel package.
     *
     * @param travelPackage The travel package in which the activity will be booked.
     */
    public void bookActivity(TravelPackage travelPackage) {
        travelPackage.bookActivity();
    }

    /**
     * Gets the remaining passenger capacity of the specified travel package.
     *
     * @param travelPackage The travel package whose remaining capacity will be retrieved.
     * @return The remaining passenger capacity.
     */
    public int getCapacity(TravelPackage travelPackage) {
        return travelPackage.getCapacity();
    }
}
