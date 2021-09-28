package edu.citytech.stocks.stocks;

import com.google.gson.Gson;
import edu.citytech.stocks.stocks.model.StockByMonthCode;
import edu.citytech.stocks.stocks.service.CalculateMonthService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class T3_StockByMonthCode {

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


    //@Test
    //@DisplayName("FUNCTIONAL Search By Month Code : Look for 2340")
    void tHW_searchByMonthCode(){

        //fix THIS test as homework

        Gson gson = new Gson();
        var stock = gson.fromJson(jsonStock, StockByMonthCode.class);
        System.out.println(stock);

        int monthCode = 0;
        var actual = monthCode;
        var expected = 2340;


        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("FUNCTIONAL (2) Search By Month Code : Look for 2340")
    void t3_searchByMonthCode(){

        int[] months = new int[] {0,3,6,9,12};

        int monthCode = CalculateMonthService.getMonthCode(months);
        var actual = monthCode;
        var expected = 2340;
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("FUNCTIONAL (3) Search By Month Code : Look for 7")
    void t4_searchByMonthCode(){

        int[] months = new int[] {1,2,3};

        int monthCode = CalculateMonthService.getMonthCode(months);
        var actual = monthCode;
        var expected = 7;
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("FUNCTIONAL (3) Search By Month Code : Look for 7")
    void t5_searchByMonthCode(){

        int[] months = new int[] {1,2,3,4,5,6,7,8,9,10,11,12};

        int monthCode = CalculateMonthService.getMonthCode(months);
        var actual = monthCode;
        var expected = 4095;
        assertEquals(expected, actual);
    }

}
