package edu.citytech.stocks.stocks;

import com.google.gson.Gson;
import edu.citytech.stocks.stocks.model.Stock;
import edu.citytech.stocks.stocks.repository.StockRepository;
import edu.citytech.stocks.stocks.utility.FileUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

public class T1_EnviromentTest {
    @Test
    void t1_enviroment() {
        Map<String, String> env = System.getenv();

        var actual = env.containsKey("CST3650_STOCK_DATA");
        var expected = true;

        assertEquals(true, actual);
    }

    @Test
    @DisplayName("Apple Stock Information")
    void t2_enviroment() {
        Map<String, String> env = System.getenv();
        var directoryName = System.getenv().get("CST3650_STOCK_DATA");

        var actual = FileUtility.getFile(directoryName + "/AAPL.json")
                .contains("Apple Inc");
        var expected = true;

        assertEquals(true, actual);
    }

    @Test
    @DisplayName("JSON to POJO")
    void t3_enviroment() {

        var directoryName = System.getenv().get("CST3650_STOCK_DATA");
        var json = FileUtility.getFile(directoryName + "/AAPL.json");
        var actual = json.contains("Apple Inc");
        var expected = true;

        Gson gson = new Gson();


        // 2. JSON string to Java object
        var stock = gson.fromJson(json, Stock.class);

        System.out.println(stock);

        assertEquals(true, actual);


    }

    @Test
    @DisplayName("Get All Stocks")
    void t4_enviroment()
    {
        StockRepository.findAll()
                .forEach(System.out::println);

       //assertEquals(true, actual);


    }
}
