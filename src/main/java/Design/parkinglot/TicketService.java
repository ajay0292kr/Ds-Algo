package Design.parkinglot;

interface TicketService {
    ParkingTicket issueTicket(Vehicle vehicle);
    void payTicket(ParkingTicket ticket, double amount);
}

