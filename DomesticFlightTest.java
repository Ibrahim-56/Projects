package std;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

public class DomesticFlightTest {

    private DomesticFlight flight;
    private LoginPage loginPage;  // Create LoginPage object
    private ButtonHandler handler;

    @BeforeEach
    void setUp() {
        loginPage = new LoginPage();  // Initialize a real LoginPage
        flight = new DomesticFlight(loginPage);  // Initialize the DomesticFlight with LoginPage
        handler = new ButtonHandler(flight, loginPage);  // Initialize ButtonHandler

        // Set values for JComboBoxes manually 
        flight.CBFrom.setSelectedIndex(0);  // "Trivandrum"
        flight.CBTo.setSelectedIndex(1);    // "Chennai"
        flight.CBClass.setSelectedIndex(0); // "Economic"
        flight.CBAdult.setSelectedIndex(0); // "1"
        flight.CBChildren.setSelectedIndex(0); // "0"
        flight.CBInfant.setSelectedIndex(0); // "0"
    }

    @Test
    void testInitialComboBoxSelections() {
        // Ensure that the ComboBoxes have the correct default selections
        assertEquals("Trivandrum", flight.CBFrom.getSelectedItem());
        assertEquals("Chennai", flight.CBTo.getSelectedItem());
        assertEquals("Economic", flight.CBClass.getSelectedItem());
        assertEquals("1", flight.CBAdult.getSelectedItem());
        assertEquals("0", flight.CBChildren.getSelectedItem());
        assertEquals("0", flight.CBInfant.getSelectedItem());
    }

    @Test
    void testButtonHandlerPricing() {
        // the pricing and time lookup
        // Set up the flight data in the `loginPage` object manually
        loginPage.row1[0][1] = "Chennai";  // Destination "Chennai"
        loginPage.row1[0][2] = "5000";    // Price for the flight "5000"
        loginPage.row1[0][3] = "10:00 AM"; // Time for the flight "10:00 AM"

        // Trigger actionPerformed manually as though the button was clicked
        ActionEvent mockEvent = new ActionEvent(flight.BFindFlight, ActionEvent.ACTION_PERFORMED, "findFlight");
        handler.actionPerformed(mockEvent);

        // After booking, the title of the flight window should display the price and time
        assertEquals("5000 10:00 AM", flight.getTitle());
    }

    @Test
    void testBookingFlowSuccess() {
        // data for pricing and availability
        loginPage.row1[0][1] = "Chennai";  // Destination "Chennai"
        loginPage.row1[0][2] = "5000";    // Price for the flight "5000"
        loginPage.row1[0][3] = "10:00 AM"; // Time for the flight "10:00 AM"

       

       

        // button press action
        ActionEvent mockEvent = new ActionEvent(flight.BFindFlight, ActionEvent.ACTION_PERFORMED, "findFlight");
        handler.actionPerformed(mockEvent);

        // After booking, the title of the flight window should show the expected result
        assertEquals("5000 10:00 AM", flight.getTitle());
    }

    @Test
    void testSeatAvailability() {
        // data for pricing and time lookup
        loginPage.row1[0][1] = "Chennai";  // Destination "Chennai"
        loginPage.row1[0][2] = "5000";    // Price for the flight "5000"
        loginPage.row1[0][3] = "10:00 AM"; // Time for the flight "10:00 AM"

        // saved booking data with seat count
        Save2 save1 = new Save2("Trivandrum", "Chennai", "Economic", 1, 1, 0, "01/01/2024", 5000, "10:00 AM");
        Save2 save2 = new Save2("Trivandrum", "Chennai", "Economic", 1, 1, 1, "01/01/2024", 5000, "10:00 AM");

        // Total seats booked (adults + children + infants)
        int totalSeatsBooked = save1.iAdult + save1.iChildren + save1.iInfant + save2.iAdult + save2.iChildren + save2.iInfant;

        // button press action
        ActionEvent mockEvent = new ActionEvent(flight.BFindFlight, ActionEvent.ACTION_PERFORMED, "findFlight");
        handler.actionPerformed(mockEvent);

        // If total seats booked exceed 60, we should show the "Seats are full" message
        if (totalSeatsBooked > 60) {
            // Assert that the title of the flight window indicates the seats are full
            assertTrue(flight.getTitle().contains("Seats are full"));
        } else {
            // If total seats booked are within limits, we check the title for flight details (price and time)
            assertEquals("5000 10:00 AM", flight.getTitle());
        }
    }

        
    }

