package com.dreamCompany.services.priceCalculationservice;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.enums.ChargesType;

public interface IPriceCalculator {
    public static final long MINUTE_CHARGE = 1;
    public static final long HOUR_CHARGE = 50;

    double calculatePrice(Ticket ticket);
    ChargesType getChargesType();
}
