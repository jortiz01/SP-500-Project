package edu.citytech.stocks.stocks.controller;

import edu.citytech.stocks.stocks.model.Stock;
import edu.citytech.stocks.stocks.repository.StockRepository;
import edu.citytech.stocks.stocks.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("sp500")


public class StockController {

    @Autowired //brings up repository into memory while loading spring boot, stays in memory, does not refresh every time
    StockService stockService;

    @GetMapping("") //redirects to correct URL, all logic is on Service Layer
    List<Stock> sp500List(@RequestParam(defaultValue = "10") int size){
        var data = stockService.getAllStocks(size);
        return data;
    }
    @GetMapping("top-10-dividends") //redirects to correct URL, all logic is on Service Layer
    List<Stock> top10Dividends (){
        var data = stockService.top10Dividends();
        return data;
    }

    /*
    //"/sp500/whatif-monthly-dividends?monthName=Jan"
    @GetMapping("whatif-monthly-dividends")
    List<Stock> whatIfMonthlyDividends (@RequestParam(defaultValue = "Jan") String monthName){
        var data = stockService.getStocksByMonthName(monthName);
        return data;

        //,@RequestParam(required = false, defaultValue = "1") int monthNumber)
    }

    //sp500/whatif-monthly-dividends?monthcode=2048
    @GetMapping("whatif-monthly-dividends")
    List<Stock> whatIfMonthlyDividends (@RequestParam(defaultValue = "2048") Integer monthCode ){
        var data = stockService.getStocksByMonthCode(monthCode);
        return data;
    }

    */

    /*

    ///sp500/whatif-monthly-dividends?monthNumber=3
    @GetMapping("whatif")
    List<Stock> whatIfMonthlyDividends (@RequestParam(required = false, defaultValue = "0") int monthNumber ){
        var data = stockService.getStocksByMonthNumber(monthNumber);
        return data;
    }
    */





    //"/sp500/whatif-monthly-dividends?monthName=Jan"
    @GetMapping("whatif-monthly-dividends")
    List<Stock> whatIfMonthlyDividends (@RequestParam(required = false) String monthName,
                                        @RequestParam(required = false, defaultValue = "0") int monthCode,
                                        @RequestParam(required = false, defaultValue = "0") int monthNumber){

        if (monthName !=null)
            return stockService.getStocksByMonthName(monthName);
        else if (monthNumber != 0 )
            return stockService.getStocksByMonthNumber(monthNumber);
        else return stockService.getStocksByMonthCode(monthCode);
    }



}
