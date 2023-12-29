import Controller.TravelPackageController;
import exception.ActivityAlreadyExistException;
import model.*;

import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws ActivityAlreadyExistException {
        // Client journey starts here
        TravelPackageController travelPackageController = new TravelPackageController();
        Scanner sc = new Scanner(System.in);

        // Creating default packages for the client
        String packageName = "FunAndJoy";
        int capacity = 5;

        // We are having a Single Destination for now
        Destination destination = new Destination("Uttarakhand");

        // List of Activities associated with Single Destination (Uttarakhand)
        List<Activity> activitiesAtUttarakhand = List.of(
                new Activity(1, Activities.BUNGEE_JUMPING, "Experience the thrill of jumping", 80.0, 15, destination),
                new Activity(2, Activities.RAFTING, "Navigate through exciting river rapids", 60.0, 20, destination),
                new Activity(3, Activities.TRACKING, "Explore the beautiful landscapes", 50.0, 20, destination),
                new Activity(4, Activities.CAMPING, "Spend a night under the stars", 40.0, 25, destination));

        // Setting Activities at Each Destination
        destination.setActivities(activitiesAtUttarakhand);

        // Creating a TravelPackage with the specified name, capacity, and destination
        TravelPackage travelPackage = travelPackageController.createPackage(packageName, capacity, destination);
        System.out.println("Package has been created Successfully");
        boolean flag = true;

        while (travelPackageController.getCapacity(travelPackage) > 0 && flag) {

            // Adding a passenger to the travelPackage
            travelPackageController.addPassenger(travelPackage);

            // Printing details of the package itinerary
            travelPackageController.printItinerary(travelPackage);

            // Printing details of passengers included in the package
            travelPackageController.printPassengerList(travelPackage);

            // User will try to book an activity
            travelPackageController.bookActivity(travelPackage);

            // Print individual passenger details
            travelPackageController.printIndividualPassengerDetails(travelPackage);

            // Print details of activities that still have spaces available
            travelPackageController.printAvailableActivities(travelPackage);

            if (travelPackageController.getCapacity(travelPackage) > 0)
                System.out.println("-------We have space available in this package; you can include more passengers-----");
            System.out.println("Do you want to continue? Press N/n to exit or any other key to continue");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("N")) {
                flag = false;
            }
        }
        if (travelPackageController.getCapacity(travelPackage) == 0) {
            System.out.println("Sorry, there is no space available in this package.");
        } else {
            System.out.println("Be relaxed and Thank you for booking with us.");
        }
    }
}
