package edu.citytech.stocks.stocks.service;


import edu.citytech.stocks.stocks.model.Stock;
import edu.citytech.stocks.stocks.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Service is Business Logic, pulling data from data repository layer

@Service
public class StockService {

    private List<Stock> stockList;
    public StockService(){
        stockList = StockRepository.findAll();
    }

    //predicates to avoid numerous if statements for rules
    private Predicate<Stock> gtDiv100B = stock -> stock.getMarketCapInBillions() > 100;
    private Predicate<Stock> paysDiv = stock -> stock.getDividends().getYield() > 0;

    public List<Stock> getAllStocks(int size){
        var data = stockList
                .stream()
                .limit(size).collect(Collectors.toList());

        return data;
    }

    public List<Stock> top10Dividends(){

        var rule = gtDiv100B.and(paysDiv); //functional coding to apply multiple rules using .and()

        var data = stockList.stream()
                .filter(rule) //filter out all bad data
                .sorted() //sort data
                .limit(10).collect(Collectors.toList()); //limit to 10

        return data;
    }


}
