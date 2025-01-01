package com.dreamCompany.Models;

import com.dreamCompany.Models.enums.ChargesType;
import com.dreamCompany.Models.enums.PaymentType;
import com.dreamCompany.Models.enums.VehicleType;
import lombok.Data;

@Data
public class Ticket {
    private String id;
    private Long startTime;
    private Long endTime;
    private String vin;
    private VehicleType vehicleType;
    private ChargesType chargesType;
    private PaymentType paymentType;
    private double totalCharge;
    private boolean isPaid;
    private String spotId;
}
