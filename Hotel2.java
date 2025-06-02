// Abstract class for staff
abstract class Staff {
    protected String name;
    protected String staffId;

    public Staff(String name, String staffId) {
        this.name = name;
        this.staffId = staffId;
    }

    public abstract void work();
}

// Receptionist class
class Receptionist extends Staff {
    public Receptionist(String name, String staffId) {
        super(name, staffId);
    }

    @Override
    public void work() {
        System.out.println(name + " is handling front desk duties.");
    }
}

// Housekeeper class
class Housekeeper extends Staff {
    public Housekeeper(String name, String staffId) {
        super(name, staffId);
    }

    @Override
    public void work() {
        System.out.println(name + " is cleaning the assigned rooms.");
    }
}

// Room class
class Room {
    private int roomNumber;
    private boolean isAvailable;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isAvailable = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void bookRoom() {
        isAvailable = false;
        System.out.println("Room " + roomNumber + " has been booked.");
    }

    public void checkoutRoom() {
        isAvailable = true;
        System.out.println("Room " + roomNumber + " has been checked out.");
    }
}

// Guest class
class Guest {
    private String name;
    private int age;

    public Guest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void checkIn(Room room) {
        if (room.isAvailable()) {
            room.bookRoom();
            System.out.println(name + " has checked into room " + room.getRoomNumber());
        } else {
            System.out.println("Room " + room.getRoomNumber() + " is not available.");
        }
    }

    public void checkOut(Room room) {
        room.checkoutRoom();
        System.out.println(name + " has checked out from room " + room.getRoomNumber());
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create staff members
        Staff receptionist = new Receptionist("Alice", "R001");
        Staff housekeeper = new Housekeeper("Bob", "H001");

        // Create a room
        Room room101 = new Room(101);

        // Create a guest
        Guest guest = new Guest("John Doe", 30);

        // Demonstrate functionality
        receptionist.work();
        housekeeper.work();
        guest.checkIn(room101);
        guest.checkOut(room101);
    }
}