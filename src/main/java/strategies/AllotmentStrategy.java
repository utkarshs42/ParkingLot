package strategies;

import models.ParkingLot;
import models.ParkingSpot;
import models.VehicleType;

public interface AllotmentStrategy {
    public ParkingSpot getParkingSpot(VehicleType vehicleType, ParkingLot parkingLot);
}
