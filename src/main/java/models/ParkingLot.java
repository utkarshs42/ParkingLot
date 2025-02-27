package models;

import java.util.List;

public class ParkingLot extends BaseModel{
    private List<ParkingFloor> floorList;
    private List<Gate> gateList;
    private List<VehicleType> allowedVehicleTypeList;
    private ParkingLotStatus status;
    private AllotmentStrategyType allotmentStrategyType;
    private FeeCalStrategyType feeCalStrategyType;

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

    public AllotmentStrategyType getAllotmentStrategy() {
        return allotmentStrategyType;
    }

    public void setAllotmentStrategy(AllotmentStrategyType allotmentStrategyType) {
        this.allotmentStrategyType = allotmentStrategyType;
    }

    public FeeCalStrategyType getFeeCalStrategy() {
        return feeCalStrategyType;
    }

    public void setFeeCalStrategy(FeeCalStrategyType feeCalStrategyType) {
        this.feeCalStrategyType = feeCalStrategyType;
    }
}
