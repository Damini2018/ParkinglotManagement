package com.dreamCompany.services.paymentservices;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.services.priceCalculationservice.PriceCalculatorManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentManager {
    private final PaymentMethodFactory paymentMethodFactory;

    private final PriceCalculatorManager priceCalculatorManager;

    public boolean deductMoney(Ticket ticket) {
        IPaymentMethod paymentMethod = paymentMethodFactory.getPaymentMethod(ticket.getPaymentType());
        priceCalculatorManager.calculatePrice(ticket);
        return paymentMethod.makePayment(ticket);
    }
}
