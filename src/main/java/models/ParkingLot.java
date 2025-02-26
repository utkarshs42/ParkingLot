package models;

import java.util.List;

public class ParkingLot extends BaseModel{
    private List<ParkingFloor> floorList;
    private List<Gate> gateList;
    private List<VehicleType> allowedVehicleTypeList;
    private ParkingLotStatus status;
    private AllotmentStrategy allotmentStrategy;
    private FeeCalStrategy feeCalStrategy;

    public List<ParkingFloor> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<ParkingFloor> floorList) {
        this.floorList = floorList;
    }

    public List<Gate> getGateList() {
        return gateList;
    }

    public void setGateList(List<Gate> gateList) {
        this.gateList = gateList;
    }

    public List<VehicleType> getAllowedVehicleTypeList() {
        return allowedVehicleTypeList;
    }

    public void setAllowedVehicleTypeList(List<VehicleType> allowedVehicleTypeList) {
        this.allowedVehicleTypeList = allowedVehicleTypeList;
    }

    public ParkingLotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingLotStatus status) {
        this.status = status;
    }

    public AllotmentStrategy getAllotmentStrategy() {
        return allotmentStrategy;
    }

    public void setAllotmentStrategy(AllotmentStrategy allotmentStrategy) {
        this.allotmentStrategy = allotmentStrategy;
    }

    public FeeCalStrategy getFeeCalStrategy() {
        return feeCalStrategy;
    }

    public void setFeeCalStrategy(FeeCalStrategy feeCalStrategy) {
        this.feeCalStrategy = feeCalStrategy;
    }
}
