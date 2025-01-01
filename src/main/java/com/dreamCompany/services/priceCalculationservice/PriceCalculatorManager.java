package com.dreamCompany.services.priceCalculationservice;

import com.dreamCompany.Models.Ticket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PriceCalculatorManager {
    private final PriceCalculatorFactory priceCalculatorFactory;

    public void calculatePrice(Ticket ticket){
        IPriceCalculator priceCalculator = priceCalculatorFactory.getPriceCalculator(ticket.getChargesType());
        priceCalculator.calculatePrice(ticket);
    }
}
