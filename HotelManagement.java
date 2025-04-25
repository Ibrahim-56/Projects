package std;
import java.util.ArrayList;
import java.util.List;

class HotelManagement {
    private List<Room> rooms;

    public HotelManagement() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public boolean bookRoom(int roomNumber, Guest guest) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && room.available) {
                room.available = false;
                room.guest = guest;
                System.out.println("Room " + roomNumber + " booked for " + guest.name);
                return true;
            }
        }
        System.out.println("Room " + roomNumber + " is not available.");
        return false;
    }

    public boolean cancelBooking(int roomNumber) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && !room.available) {
                room.available = true;
                room.guest = null;
                System.out.println("Booking for room " + roomNumber + " has been cancelled.");
                return true;
            }
        }
        System.out.println("Room " + roomNumber + " is not booked.");
        return false;
    }

    public double calculateTotalCost(int roomNumber, int nights) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) {
                return room.pricePerNight * nights;
            }
        }
        System.out.println("Room " + roomNumber + " not found.");
        return 0;
    }

    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.available) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
    public class Main {
        public static void main(String[] args) {
            // Create an instance of HotelManagement
            HotelManagement hotel = new HotelManagement();

            // Add some rooms to the hotel
            hotel.addRoom(new Room(101, "Single", 100.0));
            hotel.addRoom(new Room(102, "Double", 150.0));
            hotel.addRoom(new Room(103, "Suite", 300.0));

            // Create some guests
            Guest guest1 = new Guest("Alice", "1234567890");
            Guest guest2 = new Guest("Bob", "0987654321");

            // Book a room for a guest
            hotel.bookRoom(101, guest1);

            // Try to book the same room again (should fail)
            hotel.bookRoom(101, guest2);

            // Cancel the booking for a room
            hotel.cancelBooking(101);

            // Book the room again for a different guest
            hotel.bookRoom(101, guest2);

            // Calculate the total cost for a stay
            double cost = hotel.calculateTotalCost(101, 3);
            System.out.println("Total cost for 3 nights: $" + cost);

            // Get a list of available rooms
            List<Room> availableRooms = hotel.getAvailableRooms();
            System.out.println("Available rooms:");
            for (Room room : availableRooms) {
                System.out.println("Room " + room.roomNumber + " (" + room.type + ")");
            }
        }
    }

}
