package models;

import java.util.Date;

public class Payment extends BaseModel{
    private int amount;
    private Date time;
    private PaymentStatus paymentStatus;
    private PaymentMode mode;
    private String referenceNumber;
}
