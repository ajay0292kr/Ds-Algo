package Design.parkinglot;

import Design.parkinglot.enums.SpotType;

public class CarSpot extends ParkingSpot {
    public CarSpot(String spotId, SpotType type) {
        super(spotId, SpotType.CAR);
    }
}
