package edu.citytech.stocks.stocks.model;

public class StockByMonthCode extends Stock {

    private int monthCode;

    public int getMonthCode() {
        return monthCode;
    }

    public void setMonthCode(int monthCode) {
        this.monthCode = monthCode;
    }

    @Override
    public String toString() {
        return "StockByMonthCode{" +
                "monthCode=" + monthCode +
                "} " + super.toString();
    }
}
