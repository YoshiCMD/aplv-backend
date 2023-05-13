package com.codexd.aplv.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import static java.math.BigDecimal.ZERO;

public class BigDecimalUtil {


    public static BigDecimal clean(BigDecimal baseAmount) {
        return baseAmount != null ? baseAmount.setScale(2, RoundingMode.HALF_UP) : ZERO;
    }

    public static BigDecimal subtract(BigDecimal baseAmount, BigDecimal... subtractAmounts) {
        return Arrays.stream(subtractAmounts).reduce(baseAmount, (x, y) -> {
            if (y == null) {
                return x;
            } else {
                return x.subtract(y);
            }
        }).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal add(BigDecimal baseAmount, BigDecimal... addAmounts) {
        return Arrays.stream(addAmounts).reduce(baseAmount, (x, y) -> {
            if (y == null) {
                return x;
            } else {
                return x.add(y);
            }
        }).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal divide(BigDecimal baseAmount, BigDecimal... divideAmounts) {
        return Arrays.stream(divideAmounts).reduce(baseAmount, (x, y) -> {
            if (y == null || y.compareTo(ZERO) == 0) {
                return ZERO;
            } else {
                return x.divide(y, 8, RoundingMode.HALF_UP);
            }
        });
    }

    public static BigDecimal multiply(BigDecimal baseAmount, BigDecimal... multiplyAmounts) {
        return Arrays.stream(multiplyAmounts).reduce(baseAmount, (x, y) -> {
            if (y == null) {
                return x;
            } else {
                return x.multiply(y);
            }
        }).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal multiplyNoScale(BigDecimal baseAmount, BigDecimal... multiplyAmounts) {
        return Arrays.stream(multiplyAmounts).reduce(baseAmount, (x, y) -> {
            if (y == null) {
                return x;
            } else {
                return x.multiply(y);
            }
        });
    }

    public static BigDecimal percentage(BigDecimal base, BigDecimal pct) {
        BigDecimal percentage = divide(multiplyNoScale(base, pct), BigDecimal.valueOf(100));
        return percentage.setScale(2, RoundingMode.HALF_UP);
    }
}
