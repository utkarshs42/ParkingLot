package services;

import exceptions.GateNotFoundException;
import models.*;
import repository.GateRepository;
import repository.ParkingLotRepository;
import repository.TokenRepository;
import repository.VehicleRepository;
import strategies.AllotmentFactory;
import strategies.AllotmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TokenServices {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TokenRepository tokenRepository;
    public TokenServices(GateRepository gateRepository, VehicleRepository vehicleRepository,
                          ParkingLotRepository parkingLotRepository, TokenRepository tokenRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.tokenRepository = tokenRepository;
    }


    public Token issueToken(VehicleType vehicleType
                            ,String nameOfOwner,String vehicleNumber,Long gateId)
                            throws GateNotFoundException {


        Token token = new Token();
        token.setEntryTime(new Date());

        Optional<Gate> gateOptional = gateRepository.findById(gateId);
        if(gateOptional.isEmpty()){
            throw new GateNotFoundException();
        }
        Gate gate = gateOptional.get();
        token.setGeneratedAt(gate);
        token.setGeneratedBy(gate.getOperator());

        Optional<Vehicle> vehicleOptional = vehicleRepository.findByVehicleNumber(vehicleNumber);
        Vehicle savedVehicle;
        if(vehicleOptional.isEmpty()){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleType(vehicleType);
            vehicle.setNameOfOwner(nameOfOwner);
            vehicle.setVehicleNumber(vehicleNumber);

            savedVehicle = vehicleRepository.save(vehicle);
        }else{
            savedVehicle = vehicleOptional.get();
        }
        token.setVehicle(savedVehicle);

        ParkingLot parkingLot = parkingLotRepository.getByGate(gate);
        AllotmentStrategyType allotmentStrategyType = parkingLot.getAllotmentStrategy();

        AllotmentStrategy allotmentStrategy = AllotmentFactory.getStrategyForType(allotmentStrategyType);
        ParkingSpot parkingSpot = allotmentStrategy.getParkingSpot(vehicleType, parkingLot);
        token.setAssignedSpot(parkingSpot);



        return tokenRepository.save(token);
    }
}
