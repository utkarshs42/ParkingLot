package strategies;

import models.*;

public class RandomAllotmentStrategy implements AllotmentStrategy {
    @Override
    public ParkingSpot getParkingSpot(VehicleType vehicleType, ParkingLot parkingLot) {
        for(ParkingFloor parkingFloor : parkingLot.getFloorList()){
            for(ParkingSpot parkingSpot : parkingFloor.getParkingSpotList()){
                if(parkingSpot.getVehicleType().equals(vehicleType) &&
                        parkingSpot.getStatus() == ParkingSpotStatus.Empty ){
                    return parkingSpot;
                }
            }
        }
        return null;
    }
}
