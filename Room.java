package std;

class Room {
    int roomNumber;
    String type; // e.g., Single, Double, Suite
    double pricePerNight;
    boolean available;
    Guest guest; // null if not booked

    Room(int roomNumber, String type, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.available = true; // Initially, the room is available
        this.guest = null; // No guest initially
    }

    // Method to display room details
    public void displayRoomDetails() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Type: " + type);
        System.out.println("Price per Night: $" + pricePerNight);
        System.out.println("Available: " + (available ? "Yes" : "No"));
        if (guest != null) {
            System.out.println("Guest: " + guest.name);
        } else {
            System.out.println("Guest: None");
        }
    }
}
