package edu.citytech.stocks.stocks.service;

import java.sql.SQLOutput;
import java.util.Arrays;

public class CalculateMonthCodeService {

    public static int xgetMonthCode(int... months){ //spread operator


        int total = 0;
        for (int month :months ) {
            if (month != 0)
                total += 1 << (month - 1);
}           return total;
        }


    public static int getMonthCode(int... months){ //spread operator


        int total = Arrays.stream(months).filter(e -> e != 0)
                        .map(month -> 1 << (month - 1)).sum();

        return total;
    }



}




