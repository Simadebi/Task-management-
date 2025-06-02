import java.util.*;

class Passenger {
    private String passengerId;
    private String name;
    private String passportNo;

    public Passenger(String passengerId, String name, String passportNo) {
        this.passengerId = passengerId;
        this.name = name;
        this.passportNo = passportNo;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Passenger: " + name + " (Passport No: " + passportNo + ")";
    }
}

class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private Date departureTime;

    public Flight(String flightNumber, String origin, String destination, Date departureTime) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    @Override
    public String toString() {
        return "Flight " + flightNumber + " from " + origin + " to " + destination + " at " + departureTime;
    }
}

class TicketBooking {
    private String ticketId;
    private String seatNumber;
    private double price;

    public TicketBooking(String ticketId, String seatNumber, double price) {
        this.ticketId = ticketId;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId + ", Seat: " + seatNumber + ", Price: $" + price;
    }
}

class Reservation {
    private String reservationId;
    private Date date;
    private Flight flight;
    private List<Passenger> passengers;
    private List<TicketBooking> tickets;

    public Reservation(String reservationId, Date date, Flight flight) {
        this.reservationId = reservationId;
        this.date = date;
        this.flight = flight;
        this.passengers = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    public void addPassenger(Passenger p) {
        passengers.add(p);
    }

    public void addTicket(TicketBooking t) {
        tickets.add(t);
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId + ", Date: " + date + "\n" +
               flight + "\nPassengers: " + passengers + "\nTickets: " + tickets;
    }
}

class Employee {
    private String employeeId;
    private String name;
    private String position;

    public Employee(String employeeId, String name, String position) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee: " + name + " (" + position + ")";
    }
}

public class AirlineReservationSystem {
    public static void main(String[] args) {
        Flight flight = new Flight("FL123", "New York", "London", new Date());

        Passenger passenger1 = new Passenger("P001", "John Doe", "X1234567");
        Passenger passenger2 = new Passenger("P002", "Jane Smith", "X7654321");

        TicketBooking ticket1 = new TicketBooking("T001", "12A", 500.0);
        TicketBooking ticket2 = new TicketBooking("T002", "12B", 500.0);

        Reservation reservation = new Reservation("R001", new Date(), flight);
        reservation.addPassenger(passenger1);
        reservation.addPassenger(passenger2);
        reservation.addTicket(ticket1);
        reservation.addTicket(ticket2);

        Employee employee = new Employee("E001", "Alice Brown", "Reservation Agent");

        System.out.println(reservation);
        System.out.println(employee);
    }
}