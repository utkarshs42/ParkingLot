package models;

import java.util.List;

public class ParkingLot extends BaseModel{
    private List<ParkingFloor> floorList;
    private List<Gate> gateList;
    private List<VehicleType> allowedVehicleTypeList;
    private ParkingLotStatus status;
    private AllotmentStrategy allotmentStrategy;
    private FeeCalStrategy feeCalStrategy;
}
