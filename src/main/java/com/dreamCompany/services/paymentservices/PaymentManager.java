package com.dreamCompany.services.paymentservices;

import com.dreamCompany.Models.Payment;
import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.VehicleContext;
import com.dreamCompany.services.VehicleContextService;
import com.dreamCompany.services.paymentservices.repository.IPaymentRepo;
import com.dreamCompany.services.priceCalculationservice.PriceCalculatorManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentManager {
    private final PaymentMethodFactory paymentMethodFactory;
    private final IPaymentRepo paymentRepo;
    private final PriceCalculatorManager priceCalculatorManager;

    public boolean deductMoney(VehicleContext vehicleContext) {
        IPaymentMethod paymentMethod = paymentMethodFactory.getPaymentMethod(vehicleContext.getTicket().getPaymentType());
        priceCalculatorManager.calculatePrice(vehicleContext.getTicket());
        return paymentMethod.makePayment(vehicleContext.getPayment());
    }

    public Payment getPaymentForMethod(Ticket ticket) {
        Payment payment = new Payment();
        payment.setTicket(ticket);
        return payment;
    }

    public void savePayment(Payment payment) {
        paymentRepo.savePayment(payment);
    }
}
