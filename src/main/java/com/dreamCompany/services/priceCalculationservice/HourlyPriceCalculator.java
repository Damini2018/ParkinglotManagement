package com.dreamCompany.services.priceCalculationservice;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.enums.ChargesType;
import org.springframework.stereotype.Service;

import static com.dreamCompany.Models.enums.ChargesType.HOUR;

@Service
public class HourlyPriceCalculator implements IPriceCalculator {

    @Override
    public double calculatePrice(Ticket ticket) {
        if (ticket != null) {
            ticket.setEndTime(System.currentTimeMillis());

            double minutes = (ticket.getEndTime() - ticket.getStartTime()) / (1000.0 * 60 * 60);
            double ticketCharges = minutes * HOUR_CHARGE;
            ticketCharges =  Math.round(ticketCharges * 100.0) / 100.0;
            ticket.setTotalCharge(ticketCharges);
            return  ticketCharges;
        }
        return 0;
    }

    @Override
    public ChargesType getChargesType() {
        return HOUR;
    }
}
