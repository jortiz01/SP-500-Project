package edu.citytech.stocks.stocks;

import com.google.gson.Gson;
import edu.citytech.stocks.stocks.model.Stock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T2_StockByMonth {


    @Test
    @DisplayName("Search By Month Number : Look for 3 - March")
    void t1_searchByMonthNumber(){
        //Text Block
        String jsonStock = """ 
                        
                        {
                            "symbol": "BAC",
                            "dividends": {
                                "frequency": "quarterly",
                                "months": [
                                    {
                                        "9": 0.21
                                    },
                                    {
                                        "6": 0.18
                                    },
                                    {
                                        "3": 0.18
                                    },
                                    {
                                        "12": 0.18
                                    }
                                ],
                                "yield": 0.01849675592909907
                            },
                            "price": 40.27,
                            "marketCapInBillions": 338.868179288,
                            "companyName": "Bank Of America Corp.",
                            "momentumScore": 50.24752475247524,
                            "sector": "Financials",
                            "subSector": "Diversified Banks"
                        }            
                """;

        Gson gson = new Gson();
        var stock = gson.fromJson(jsonStock, Stock.class);

        System.out.println(stock);

        boolean actual = false;
        //write logic that will test to see if BAC pays on
        //the 3rd month

        //for (Map<Integer, Float> name : stock.getDividends().getMonths())
            //System.out.println(name);

        int input = 6;

        for (Map<Integer, Float> name : stock.getDividends().getMonths())
            if (name.containsKey(input)){
                actual = true;
                System.out.println(stock.getCompanyName() + " pays a dividend on the month: " + input);
            }

        boolean expected = true;





        assertEquals(expected, actual);
    }

}
