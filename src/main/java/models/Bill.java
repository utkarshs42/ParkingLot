package models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel{
    private Token token;
    private Date exitTime;
    private int totalamount;
    private Operator generatedBy;
    private Gate generatedAt;
    private List<Payment> payments;
}
