package services;

import exceptions.GateNotFoundException;
import models.Gate;
import models.Token;
import models.Vehicle;
import models.VehicleType;
import repository.GateRepository;
import repository.VehicleRepository;

import java.util.Date;
import java.util.Optional;

public class TokenServices {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    public TokenServices(GateRepository gateRepository, VehicleRepository vehicleRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
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

            savedVehicle = vehicleRepository.save(Vehicle vehicle);
        }else{
            savedVehicle = vehicleOptional.get();
        }
        token.setVehicle(savedVehicle);
        

        return token;
    }
}
