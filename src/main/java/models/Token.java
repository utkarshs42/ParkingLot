package models;

import java.util.Date;

public class Token extends BaseModel{
    private String number;
    private Date entryTime;
    private Vehicle vehicle;
    private ParkingSpot assignedSpot;
    private Gate generatedAt;
    private Operator generatedBy;

}
