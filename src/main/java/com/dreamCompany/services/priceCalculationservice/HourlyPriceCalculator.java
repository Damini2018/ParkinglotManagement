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
            if (ticket.getEndTime() ==null) {
                ticket.setEndTime(System.currentTimeMillis());
            }
            double hour = (int)Math.ceil((ticket.getEndTime() - ticket.getStartTime() )/ (1000.0 * 60 * 60));
            double ticketCharges = hour * HOUR_CHARGE;
            ticketCharges = Math.round(ticketCharges * 100.0) / 100.0;
            ticket.setTotalCharge(ticketCharges);
            return ticketCharges;
        }
        return 0;
    }
//    long differenceMs = ticket.getEndTime() - ticket.getStartTime();
//    //            int hours = (int) Math.ceil(differenceMs / (1000.0 * 60 * 60));
//    double ticketCharges = hours * HOUR_CHARGE;
//    ticketCharges = Math.round(ticketCharges * 100.0) / 100.0;
//            ticket.setTotalCharge(ticketCharges);
//            return ticketCharges;
    @Override
    public ChargesType getChargesType() {
        return HOUR;
    }
}
