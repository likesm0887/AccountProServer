package com.accountProServer.AccountProServer.infrastructure.utitly;


import com.accountProServer.AccountProServer.domain.EnumType;

import java.util.Arrays;

public class EnumParser<T extends Enum<T>> {
    public  Enum<T> parse(Class object, String serialCode) {
        return Arrays.stream(object.getEnumConstants())
                .map(EnumParser::parse)
                .filter(enums -> enums.getDataBaseValue() == Integer.valueOf(serialCode))
                .map(e -> (Enum) e)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("error CompanyOrigin serialCode"));
    }

    private static <T extends Enum> EnumType<? extends Enum> parse(Object object) {
        return (EnumType<T>) object;
    }
}

