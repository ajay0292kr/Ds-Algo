package Design.parkinglot;

import Design.parkinglot.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private String floorId;
    private List<ParkingSpot> spots;

    public ParkingFloor(String floorId) {
        this.floorId = floorId;
        this.spots = new ArrayList<>();
    }

    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    public ParkingSpot findFreeSpot(VehicleType type) {
        for (ParkingSpot spot : spots) {
            if (spot.isFree() && spot.getType().name().equals(type.name())) {
                return spot;
            }
        }
        return null;
    }

}
