package com.dreamCompany.services.paymentservices;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.enums.PaymentType;

public interface IPaymentMethod {
    boolean makePayment(Ticket ticket);
    PaymentType getPaymentType();
}