package edu.citytech.stocks.stocks.service;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CalculateMonthService {

    private static Map<String, Integer> map = new HashMap<>();
    static{
        System.out.println(new Date());
        map.put("Jan",1);
        map.put("Feb",2);
        map.put("Mar",3);
        map.put("Apr",4);
        map.put("May",5);
        map.put("Jun",6);
        map.put("Jul",7);
        map.put("Aug",8);
        map.put("Sep",9);
        map.put("Oct",10);
        map.put("Nov",11);
        map.put("Dec",12);
    }

    private static Map<Integer, Integer> mapCode = new HashMap<>();
    static{
        System.out.println(new Date());
        mapCode.put(0,0);
        mapCode.put(1,1);
        mapCode.put(2,2);
        mapCode.put(4,3);
        mapCode.put(8,4);
        mapCode.put(16,5);
        mapCode.put(32,6);
        mapCode.put(64,7);
        mapCode.put(128,8);
        mapCode.put(256,9);
        mapCode.put(512,10);
        mapCode.put(1024,11);
        mapCode.put(2048,12);
    }



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


    public static int getMonthName(String monthName) {

        if (!map.containsKey(monthName))
            return -1;

        int monthNumber = map.get(monthName);
        return monthNumber;
    }

    public static int getMonthNum(Integer monthNum) {

        if (!map.containsValue(monthNum))
            return -1;

        int monthNumber = map.get(monthNum);
        return monthNumber;
    }

    public static int getMonthNameByCode(Integer monthCode) {

        if (!mapCode.containsKey(monthCode))
            return -1;

        int monthNumber = mapCode.get(monthCode);

        return monthNumber;
    }
}




