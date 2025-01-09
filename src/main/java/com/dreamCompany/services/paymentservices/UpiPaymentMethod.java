package com.dreamCompany.services.paymentservices;

import com.dreamCompany.Models.Payment;
import com.dreamCompany.Models.enums.PaymentType;
import com.dreamCompany.services.paymentservices.repository.IPaymentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.dreamCompany.Models.enums.PaymentType.UPI;

@Service
@RequiredArgsConstructor
public class UpiPaymentMethod implements IPaymentMethod {
    private final IPaymentRepo paymentRepo;

    @Override
    public boolean makePayment(Payment payment) {
        payment.getTicket().setPaid(true);
        System.out.println("Ticket paid for rupees " + payment.getTicket().getTotalCharge());
        payment.setReferenceId(paymentRepo.savePayment(payment));
        return true;
    }

    @Override
    public PaymentType getPaymentType() {
        return UPI;
    }
}

