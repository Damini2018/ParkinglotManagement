package com.dreamCompany.services.paymentservices.repository;

import com.dreamCompany.Models.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentRepoImpl implements  IPaymentRepo{
    private final MongoTemplate mongoTemplate;

    @Override
    public String savePayment(Payment payment) {
        return mongoTemplate.save(payment).getReferenceId();
    }

    @Override
    public Payment getPaymentByReferenceId(String id) {
        Query query = new Query();
        Criteria criteria = Criteria.where("referenceId").is(id);
        query.addCriteria(criteria);
        return mongoTemplate.findOne(query, Payment.class);
    }
}
