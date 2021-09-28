package edu.citytech.stocks.stocks.repository;

import com.google.gson.Gson;
import edu.citytech.stocks.stocks.model.Stock;
import edu.citytech.stocks.stocks.utility.FileUtility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class StockRepository {

    private static Stock getStockInfo(File file){
        var directoryName = file.toString();

        Gson gson = new Gson();
        var json = FileUtility.getFile(directoryName);

        // 2. JSON string to Java object
        var stock = gson.fromJson(json, Stock.class);

        return stock;

    }
    public static List<Stock> findAll() {

        //can be used on any machine with this environment
        var dirLocation = System.getenv().get("CST3650_STOCK_DATA");


        try {
            List<Stock> stockList = Files.list(Paths.get(dirLocation))
                        .map(Path::toFile)
                        .map( e -> getStockInfo(e))
                        .collect(Collectors.toList());

            System.out.println("Loading Data from Stock Repository: " + new Date());

            return stockList;

        } catch (IOException e) {
            e.printStackTrace();
        }


        return new ArrayList<>();
    }
}