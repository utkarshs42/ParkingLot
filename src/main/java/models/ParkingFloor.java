package models;

import java.util.List;

public class ParkingFloor extends BaseModel {
    private List<ParkingSpot> parkingSpotList;
    private int floorNumber;
    private ParkingFloorStatus status;
}
