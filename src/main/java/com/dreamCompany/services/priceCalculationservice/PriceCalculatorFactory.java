package com.dreamCompany.services.priceCalculationservice;

import com.dreamCompany.Models.enums.ChargesType;
import com.dreamCompany.services.util.ListUtil;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PriceCalculatorFactory {
    private final List<IPriceCalculator> priceCalculators;
    private Map<ChargesType, IPriceCalculator> priceCalculatorMap;

    @PostConstruct
    public void set() {
        priceCalculatorMap = new HashMap<>();
        for (IPriceCalculator priceCalculator : ListUtil.nullSafeEmptyList(priceCalculators)) {
            priceCalculatorMap.put(priceCalculator.getChargesType(), priceCalculator);
        }
    }

    public IPriceCalculator getPriceCalculator(ChargesType chargesType) {
        return priceCalculatorMap.getOrDefault(chargesType, null);
    }
}
