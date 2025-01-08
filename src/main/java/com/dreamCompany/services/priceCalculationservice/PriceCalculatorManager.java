package com.dreamCompany.services.priceCalculationservice;

import com.dreamCompany.Models.Ticket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PriceCalculatorManager {
    private final PriceCalculatorFactory priceCalculatorFactory;

    public double calculatePrice(Ticket ticket){
        IPriceCalculator priceCalculator = priceCalculatorFactory.getPriceCalculator(ticket.getChargesType());
        return priceCalculator.calculatePrice(ticket);
    }
}
