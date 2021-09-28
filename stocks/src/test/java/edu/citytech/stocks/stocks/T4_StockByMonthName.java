package edu.citytech.stocks.stocks;

import com.google.gson.Gson;
import edu.citytech.stocks.stocks.model.StockByMonthCode;
import edu.citytech.stocks.stocks.service.CalculateMonthService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Search by month name")
public class T4_StockByMonthName {

    @Test
    @DisplayName("Search By Month Name: Jan")
    void t1_searchByMonthName(){

        int actual = CalculateMonthService.getMonthName("Jan");
        int expected = 1;
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Search By Month Name: Feb")
    void t2_searchByMonthName(){

        int actual = CalculateMonthService.getMonthName("Feb");
        int expected = 2;


        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Search By Month Name: March")
    void t3_searchByMonthName(){

        int actual = CalculateMonthService.getMonthName("Mar");
        int expected = 3;


        assertEquals(expected, actual);
    }



}
