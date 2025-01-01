package com.dreamCompany.services.util;

import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class ListUtil extends CollectionUtils {
    public static <T> List<T> nullSafeEmptyList(List<T> list) {
        return CollectionUtils.isEmpty(list) ? new ArrayList<>() : list;
    }
}
