package com.dreamCompany.services.priceCalculationservice;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.enums.ChargesType;
import org.springframework.stereotype.Service;

import static com.dreamCompany.Models.enums.ChargesType.MINUTE;

@Service
public class MinutelyPriceCalculator implements IPriceCalculator {

    @Override
    public double calculatePrice(Ticket ticket) {
        if (ticket != null) {
            ticket.setEndTime(System.currentTimeMillis());
            double minutes = (ticket.getEndTime() - ticket.getStartTime()) / (1000000.0 * 60);
            double ticketCharges = minutes * MINUTE_CHARGE;
            ticket.setTotalCharge(ticketCharges);
            return ticketCharges;
        }
        return 0;
    }

    @Override
    public ChargesType getChargesType() {
        return MINUTE;
    }
}
