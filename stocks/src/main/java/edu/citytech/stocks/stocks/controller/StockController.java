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
import java.util.stream.Collectors;

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

}
