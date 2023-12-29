import Controller.TravelPackageController;
import exception.ActivityAlreadyExistException;
import model.*;

import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws ActivityAlreadyExistException {
        // Client journey
        TravelPackageController travelPackageController = new TravelPackageController();
        Scanner sc = new Scanner(System.in);

        // creating default packages for the client
        String packageName = "FunAndJoy";
        int capacity = 5;

        //  We are having Single Destination for now

        Destination destination = new Destination("Uttarakhand");


        // List of Activity associate with Single Destination which is Uttarakhand
        List<Activity> activitiesAtUttarakhand = List.of(new Activity(1,Activities.BUNGEE_JUMPING, "Experience the thrill of jumping", 80.0, 15, destination),
                new Activity(2,Activities.RAFTING, "Navigate through exciting river rapids", 60.0, 20,destination),
                new Activity(3,Activities.TRACKING, "Explore the beautiful landscapes", 50.0, 20, destination),
                new Activity(4,Activities.CAMPING, "Spend a night under the stars", 40.0, 25,destination));

        // Setting Activity at Each Destination
        destination.setActivities(activitiesAtUttarakhand);



        TravelPackage travelPackage = travelPackageController.createPackage(packageName, capacity, destination);
        System.out.println("Package has been created Successfully");
        boolean flag = true;

        while (travelPackageController.getCapacity(travelPackage)>0 && flag){

            // adding passenger to the travelPackage
            travelPackageController.addPassenger(travelPackage);

            // printing details of package
            travelPackageController.printItinerary(travelPackage);

            // printing details of passengers which are include in the package
            travelPackageController.printPassengerList(travelPackage);

            //User will try to bookActivity
            travelPackageController.bookActivity(travelPackage);

            // print individual passenger details
            travelPackageController.printIndividualPassengerDetails(travelPackage);

            // Print the details of all the activities that still have spaces available
            travelPackageController.printAvailableActivities(travelPackage);

            if(travelPackageController.getCapacity(travelPackage)>0)
                System.out.println("-------We have space available in this package you can include more passengers-----");
            System.out.println("Do you want to continue press N/n or N/n");
            String input  = sc.nextLine();
            if(input.equalsIgnoreCase("N")){
                flag = false;
            }
        }
        if(travelPackageController.getCapacity(travelPackage) == 0){
            System.out.println("Sorry , there is no space available in this package ");
        }
        else{
            System.out.println("Be relax and Thank for you booking with us");
        }

    }
}