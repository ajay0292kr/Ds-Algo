package Design.parkinglot;

import Design.parkinglot.enums.SpotType;

abstract class ParkingSpot {
    private String spotId;
    private SpotType type;
    private boolean isFree;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotId, SpotType type) {
        this.spotId = spotId;
        this.type = type;
        this.isFree = true;
    }
    public boolean assignVehicle(Vehicle vehicle) {
        if (!isFree) return false;
        this.parkedVehicle = vehicle;
        this.isFree = false;
        return true;
    }

    public void removeVehicle() {
        this.parkedVehicle = null;
        this.isFree = true;
    }
    public boolean isFree() {
        return isFree;
    }

    public SpotType getType() {
        return type;
    }

}
