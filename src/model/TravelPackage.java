package model;

import exception.ActivityAlreadyExistException;
import exception.InvalidActivityNumberException;

import java.util.*;
/**
 * A class representing a travel package in the travel package booking system.
 * Each travel package has a name, capacity, itinerary, and a list of passengers.
 */
public class TravelPackage {
    private String name;
    private int capacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    Scanner sc = new Scanner(System.in);

    /**
     * Private constructor to create a TravelPackage instance.
     *
     * @param name      The name of the travel package.
     * @param capacity  The capacity of the travel package.
     * @param itinerary The list of destinations in the itinerary.
     */
    private TravelPackage(String name, int capacity, List<Destination> itinerary) {
        this.name = name;
        this.capacity = capacity;
        this.itinerary = itinerary;
        this.passengers = new ArrayList<>();
    }

    // Getter and setter methods for class attributes


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Destination> getItinerary() {
        return itinerary;
    }

    public void setItinerary(List<Destination> itinerary) {
        this.itinerary = itinerary;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    /**
     * Method to print the itinerary details of the travel package.
     */
    public void printItinerary() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("------hear is the list of your package details-------");
        System.out.println("Package Name - " + getName());
        System.out.println("Destination - " + Objects.requireNonNull(getItinerary().stream().findFirst().orElse(null)).getName());
        System.out.println("------------Activity available at this destination------------");
        for (Destination dest:
             itinerary) {
            System.out.println("destination Name - " + dest.getName());
            List<Activity> activities = dest.getActivities();
            System.out.println("Available Activity at this Destination");
            for (Activity activity:
                 activities) {
                System.out.println("**********************************************************");
                System.out.println("Activity id - ||  " + activity.getId());
                System.out.println("Activity Name - ||  " + activity.getName());
                System.out.println("Cost - ||   " + activity.getCost());
                System.out.println("Capacity - ||   "+ activity.getCapacity() );
                System.out.println("Description - ||    " + activity.getDescription());
            }
        }
        System.out.println("---------------------------------------------------------------------");
    }

    /**
     * Method to add passengers to the travel package.
     */

    public void addPassenger() {
        int spaceAvailable = capacity;
        System.out.println("---------------------------------------------------------------------");
       while (spaceAvailable>0){
        System.out.println("Please provide the user details");
        System.out.println("1 - StandardPassenger");
        System.out.println("2 - GoldPassenger");
        System.out.println("3- PremiumPassenger");
        int num = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the name of the Passenger");
        String name = sc.nextLine();
        double balance = 0;
        if(num!=3){
            System.out.println("Please provide your balance");
            balance = sc.nextDouble();
            sc.nextLine();
        }
        int number = (int)Math.floor(Math.random()*10)+1;
        Passenger passenger = null;
        switch (num){
            case 1 -> passenger = new StandardPassenger(name,number,balance);
            case 2 -> passenger = new GoldPassenger(name,number,balance);
            case 3 -> passenger = new PremiumPassenger(name,number);
        }

        // setting passenger in the Package
        getPassengers().add(passenger);
        spaceAvailable-=1;
           System.out.println("Do you want to add more Passengers if yes please press Y/y or if No please press N/n ");
           String input = sc.nextLine();
           if(input.equalsIgnoreCase("N")){
               break;
           }
           System.out.println("------------------------------");
       }
        System.out.println("you have successfully added the passengers details Now it's time for Activity details");

        System.out.println("---------------------------------------------------------------------");
    }

    /**
     * Method to print the list of passengers in the travel package.
     */

    public void printPassengerList(){

        System.out.println("---------------------------------------------------------------------");
        System.out.println("--------hear is the list of your package details with PassengerList---------");
        System.out.println("Package Name - " + getName());
        System.out.println("Passenger capacity for this package - " + getCapacity());
        System.out.println("Number of passengers currently enrolled in this package - " + getPassengers().size());
        System.out.println("--------Passenger Details which are enrolled in this package--------");
        for (Passenger passenger:
             getPassengers()) {
            System.out.println("**********************************************************");
            System.out.println("Name - ||   " + passenger.getName());
            System.out.println("Number - || " + passenger.getNumber());
        }

        System.out.println("---------------------------------------------------------------------");
    }
    /**
     * Method to book activities for passengers in the travel package.
     */

    public void bookActivity() throws InvalidActivityNumberException {
            Destination destination = getItinerary().stream().findFirst().orElse(null);
            assert destination != null;
        destination.bookActivity(getPassengers());
    }

    /**
     * Method to print details of individual passengers in the travel package.
     */
    public void printIndividualPassengerDetails() {
        passengers.forEach(Passenger::printPassengerDetails);
    }

    /**
     * Method to print details of available activities in the travel package.
     */
    public void printAvailableActivities() {
        getItinerary().forEach(Destination::printAvailableActivities);
    }


    /**
     * Builder class for constructing TravelPackage instances.
     */

    public static class Builder{
        private String name;
        private int capacity;
        private List<Destination> itinerary;
        private List<Passenger> passengers;

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public int getCapacity() {
            return capacity;
        }

        public Builder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public List<Destination> getItinerary() {
            return itinerary;
        }

        public Builder setItinerary(List<Destination> itinerary) {
            this.itinerary = itinerary;
            return this;
        }

        public List<Passenger> getPassengers() {
            return passengers;
        }

        public Builder setPassengers(List<Passenger> passengers) {
            this.passengers = passengers;
            return this;
        }

        /**
         * Method to build a TravelPackage instance.
         *
         * @return A TravelPackage instance.
         * @throws ActivityAlreadyExistException If duplicate activities are found at destinations.
         */

        public TravelPackage build() throws ActivityAlreadyExistException {
            // need to perform validation if required
            validActivityAtDestination();
            return new TravelPackage(name,capacity,itinerary);
        }



        /**
         * Checks for duplicate activities at each destination in the itinerary.
         *
         * @throws ActivityAlreadyExistException If duplicates are found.
         */
        private void validActivityAtDestination() throws ActivityAlreadyExistException {
            for (Destination destination : itinerary) {
                Set<Activities> activitiesName = new HashSet<>();
                for (Activity activity:
                        destination.getActivities()) {
                    activitiesName.add(activity.getName());
                }
                if(activitiesName.size() != destination.getActivities().size()){
                    throw new ActivityAlreadyExistException("At this destination called "+ destination.getName() + " we have duplicate activity");
                }
            }
        }


    }
}
