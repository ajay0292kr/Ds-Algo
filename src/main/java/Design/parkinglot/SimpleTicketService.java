package Design.parkinglot;

public class SimpleTicketService implements TicketService {
    private int ticketCounter = 1;

    @Override
    public ParkingTicket issueTicket(Vehicle vehicle) {
        String ticketNum = "TICKET_" + ticketCounter++;
        return new ParkingTicket(ticketNum);
    }

    @Override
    public void payTicket(ParkingTicket ticket, double amount) {
        ticket.closeTicket(amount);
    }
}
