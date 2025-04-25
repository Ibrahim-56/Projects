package std;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class HotelManagementTest {

    private HotelManagement hotelManagement;
    private Room room1, room2, room3;
    private Guest guest1, guest2;

    @BeforeEach
    void setUp() {
        // Initialize hotel management, rooms, and guests
        hotelManagement = new HotelManagement();
        room1 = new Room(101, "Single", 100.0);
        room2 = new Room(102, "Double", 150.0);
        room3 = new Room(103, "Suite", 300.0);
        
        hotelManagement.addRoom(room1);
        hotelManagement.addRoom(room2);
        hotelManagement.addRoom(room3);
        
        guest1 = new Guest("Fahad", "1234567890");
        guest2 = new Guest("Rashed", "0987654321");
    }

    // Test case for adding rooms to the hotel
    @Test
    void testAddRoom() {
        hotelManagement.addRoom(new Room(104, "Penthouse", 500.0));
        List<Room> availableRooms = hotelManagement.getAvailableRooms();
        assertEquals(4, availableRooms.size(), "There should be 4 rooms available.");
    }

    // Test case for booking a room successfully
    @Test
    void testBookRoomSuccess() {
        boolean result = hotelManagement.bookRoom(101, guest1);
        assertTrue(result, "Room 101 should be booked for Alice.");
    }

    // Test case for trying to book a room that's already booked (failure)
    @Test
    void testBookRoomFailureRoomAlreadyBooked() {
        hotelManagement.bookRoom(101, guest1);  // Fahad books room 101
        boolean result = hotelManagement.bookRoom(101, guest2);  // Rashed tries to book the same room
        assertFalse(result, "Room 101 should not be available for Bob after Alice's booking.");
    }

    // Test case for cancelling a booking successfully
    @Test
    void testCancelBookingSuccess() {
        hotelManagement.bookRoom(101, guest1);  // Fahad books room 101
        boolean result = hotelManagement.cancelBooking(101);  // Cancel the booking
        assertTrue(result, "Room 101 booking should be cancelled successfully.");
    }

    // Test case for trying to cancel a room that is not booked (failure)
    @Test
    void testCancelBookingFailureRoomNotBooked() {
        boolean result = hotelManagement.cancelBooking(101);  // No booking on room 101
        assertFalse(result, "Room 101 should not be cancellable if it wasn't booked.");
    }

    // Test case for calculating the total cost of a room
    @Test
    void testCalculateTotalCost() {
        hotelManagement.bookRoom(101, guest1);  // Fahad books room 101
        double totalCost = hotelManagement.calculateTotalCost(101, 3);  // Calculate for 3 nights
        assertEquals(300.0, totalCost, "Total cost for 3 nights should be $300.");
    }

    // Test case for calculating cost for a room that doesn't exist
    @Test
    void testCalculateTotalCostRoomNotFound() {
        double totalCost = hotelManagement.calculateTotalCost(999, 3);  // Invalid room number
        assertEquals(0.0, totalCost, "Total cost should be 0 if room number is not found.");
    }

    // Test case for getting available rooms when some are booked
    @Test
    void testGetAvailableRooms() {
        hotelManagement.bookRoom(101, guest1);  // Fahad books room 101
        List<Room> availableRooms = hotelManagement.getAvailableRooms();
        assertEquals(2, availableRooms.size(), "There should be 2 rooms available after booking room 101.");
    }

    // Test case for getting available rooms when all rooms are booked
    @Test
    void testGetAvailableRoomsWhenNoneAvailable() {
        hotelManagement.bookRoom(101, guest1);  // Fahad books room 101
        hotelManagement.bookRoom(102, guest2);  // Rashed books room 102
        hotelManagement.bookRoom(103, guest1);  // Fahad books room 103
        List<Room> availableRooms = hotelManagement.getAvailableRooms();
        assertTrue(availableRooms.isEmpty(), "There should be no available rooms when all rooms are booked.");
    }

    // Test case for booking an edge case room (a newly added room)
    @Test
    void testBookRoomEdgeCase() {
        hotelManagement.addRoom(new Room(104, "Penthouse", 500.0));
        boolean result = hotelManagement.bookRoom(104, guest2);
        assertTrue(result, "Penthouse room 104 should be bookable.");
    }
}
