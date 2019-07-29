package com.number;

import java.math.BigDecimal;

/**
 * 发现double相乘有精度缺失的问题
 */
public class rounding {
    public static void main(String[] args) {
        Double a = 3218.5;
        Double b = 0.03;
        Double d = a * b;
        System.out.println(d);
        Double e = d * 100;
        System.out.println(e);
        System.out.println(round(e));
        Double res = round(e) / 100;
        System.out.println(res);
        //
        System.out.println(round3(3218.5 * 0.03));

    }

    public static Double round(Double number) {
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(number));
        return bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static Double round3(Double number) {
        //先将数目乘以100，如果单位是元，相当于转成分，最后再除以100。解决二进制double相乘出现的问题
        Double temp = number * 100;
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(temp));
        //直接取整
        Double roundNumber = bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
        return roundNumber / 100;
    }
}
