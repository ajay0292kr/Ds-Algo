package Design.parkinglot;

import Design.parkinglot.enums.TicketStatus;

import java.util.Date;

public class ParkingTicket {
    private String ticketNumber;
    private Date entryTime;
    private Date exitTime;
    private double amount;
    private TicketStatus status;

    public ParkingTicket(String ticketNumber) {
        this.ticketNumber = ticketNumber;
        this.entryTime = new Date();
        this.status = TicketStatus.ACTIVE;
    }

    public void closeTicket(double amount) {
        this.exitTime = new Date();
        this.amount = amount;
        this.status = TicketStatus.PAID;
    }

    public TicketStatus getStatus() {
        return status;
    }

}
