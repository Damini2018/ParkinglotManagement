package com.dreamCompany.services.paymentservices;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.enums.PaymentType;
import org.springframework.stereotype.Service;

import static com.dreamCompany.Models.enums.PaymentType.CASH;

@Service
public class CashPaymentMethod implements IPaymentMethod {
    @Override
    public boolean makePayment(Ticket ticket) {
        ticket.setPaid(true);
        return true;
    }

    @Override
    public PaymentType getPaymentType() {
        return CASH;
    }
}
