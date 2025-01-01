package com.dreamCompany.services.paymentservices;

import com.dreamCompany.Models.enums.PaymentType;
import com.dreamCompany.services.util.ListUtil;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PaymentMethodFactory {
    private final List<IPaymentMethod> paymentMethods;
    private Map<PaymentType, IPaymentMethod> paymentTypeIPaymentMethodMap;

    // we can also do like above if we maintain a map or bellow if the code is less complex
    @PostConstruct
    public void set() {
        paymentTypeIPaymentMethodMap = new HashMap<>();
        for(IPaymentMethod paymentMethod : ListUtil.nullSafeEmptyList(paymentMethods)){
            paymentTypeIPaymentMethodMap.put(paymentMethod.getPaymentType(), paymentMethod);
        }
    }

    public IPaymentMethod getPaymentMethod(PaymentType paymentType){
        return paymentTypeIPaymentMethodMap.getOrDefault(paymentType,null);
    }
}
