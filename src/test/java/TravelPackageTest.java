package test.java;

import Controller.TravelPackageController;
import exception.ActivityAlreadyExistException;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This class contains unit tests for the TravelPackage class and its related functionality.
 */
public class TravelPackageTest {
    private TravelPackage travelPackage;

    private TravelPackageController travelPackageController;

    /**
     * Set up the test environment by creating a sample TravelPackage with a destination and activities.
     *
     * @throws ActivityAlreadyExistException If there is an issue with creating the activities.
     */
    @BeforeEach
    void setUp() throws ActivityAlreadyExistException {

        Destination destination = new Destination("Uttarakhand");
        List<Activity> activitiesAtUttarakhand = List.of(
                new Activity(1, Activities.BUNGEE_JUMPING, "Experience the thrill of jumping", 80.0, 15, destination),
                new Activity(2, Activities.RAFTING, "Navigate through exciting river rapids", 60.0, 20, destination),
                new Activity(3, Activities.TRACKING, "Explore the beautiful landscapes", 50.0, 20, destination),
                new Activity(4, Activities.CAMPING, "Spend a night under the stars", 40.0, 25, destination)
        );
        destination.setActivities(activitiesAtUttarakhand);

        travelPackageController = new TravelPackageController();
        travelPackage = travelPackageController.createPackage("Test Package", 10, destination);
        travelPackage.getPassengers().add((new StandardPassenger("Akhil",1,100)));

    }

    /**
     * Test the creation of a TravelPackage.
     *
     * @throws ActivityAlreadyExistException If there is an issue with creating the activities.
     */
    @Test
    void testCreatePackage() throws ActivityAlreadyExistException {

        assertNotNull(travelPackage);
        assertEquals("Test Package", travelPackage.getName());
        assertEquals(10, travelPackage.getCapacity());
        assertEquals(1, travelPackage.getItinerary().size());
        assertEquals(1, travelPackage.getItinerary().size());
    }

    /**
     * Test adding a passenger to the TravelPackage.
     *
     * @throws ActivityAlreadyExistException If there is an issue with creating the activities.
     */

    @Test
    void testAddPassenger() throws ActivityAlreadyExistException {

        assertEquals(1, travelPackage.getPassengers().size());
    }

    /**
     * Test printing the itinerary of the TravelPackage.
     *
     * @throws ActivityAlreadyExistException If there is an issue with creating the activities.
     */

    @Test
    void testPrintItinerary() throws ActivityAlreadyExistException {

        travelPackageController.printItinerary(travelPackage);
    }

    /**
     * Test signing up a passenger for an activity.
     *
     * @throws ActivityAlreadyExistException If there is an issue with creating the activities.
     */
    @Test
    void testSignUpForActivity() throws ActivityAlreadyExistException {
        Passenger passenger = travelPackage.getPassengers().get(0);
        Activity activity = travelPackage.getItinerary().get(0).getActivities().get(0);

        assertEquals(15, activity.getCapacity());

        passenger.signUpForActivity(activity,passenger);

        assertEquals(14, activity.getAvailableSpace()); // One passenger signed up
        assertEquals(1, passenger.getActivities().size());
    }

    /**
     * Test building a TravelPackage with duplicate activities.
     */

    @Test
    void testBuildTravelPackageWithDuplicateActivity() {
        Destination destination = new Destination("Uttarakhand");
        Activity activity1 = new Activity(1, Activities.RAFTING, "Rafting adventure", 50.0, 10, destination);
        Activity activity2 = new Activity(2, Activities.RAFTING, "Another rafting adventure", 60.0, 15, destination);

        destination.setActivities(Arrays.asList(activity1, activity2));

        assertThrows(ActivityAlreadyExistException.class, () ->
                new TravelPackage.Builder()
                        .setName("AdventurePackage")
                        .setCapacity(20)
                        .setItinerary(Arrays.asList(destination))
                        .build()
        );
    }


}
