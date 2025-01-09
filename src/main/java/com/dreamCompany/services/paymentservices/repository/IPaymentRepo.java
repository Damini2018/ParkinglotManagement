package com.dreamCompany.services.paymentservices.repository;

import com.dreamCompany.Models.Payment;

public interface IPaymentRepo {
    String savePayment(Payment payment);
    Payment getPaymentByReferenceId(String id);
}
