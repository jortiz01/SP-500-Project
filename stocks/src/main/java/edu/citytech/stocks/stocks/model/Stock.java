package edu.citytech.stocks.stocks.model;

public class Stock implements Comparable<Stock> //implement comparable to compare stock to itself
{
    private String symbol;

    private float price;

    @Override
    public String toString() {
        return "Stock{" +
                "symbol='" + symbol + '\'' +
                ", price=" + price +
                ", marketCapInBillions=" + marketCapInBillions +
                ", dividends=" + dividends +
                ", companyName='" + companyName + '\'' +
                ", momentumScore=" + momentumScore +
                ", subSector='" + subSector + '\'' +
                ", sector='" + sector + '\'' +
                '}';
    }

    private float marketCapInBillions;

    private Dividends dividends;

    private String companyName;

    private float momentumScore;

    private String subSector;

    private String sector;

    public String getSymbol ()
    {
        return symbol;
    }

    public void setSymbol (String symbol)
    {
        this.symbol = symbol;
    }

    public float getPrice ()
    {
        return price;
    }

    public void setPrice (float price)
    {
        this.price = price;
    }

    public float getMarketCapInBillions ()
    {
        return marketCapInBillions;
    }

    public void setMarketCapInBillions (float marketCapInBillions)
    {
        this.marketCapInBillions = marketCapInBillions;
    }

    public Dividends getDividends ()
    {
        return dividends;
    }

    public void setDividends (Dividends dividends)
    {
        this.dividends = dividends;
    }

    public String getCompanyName ()
    {
        return companyName;
    }

    public void setCompanyName (String companyName)
    {
        this.companyName = companyName;
    }

    public float getMomentumScore ()
    {
        return momentumScore;
    }

    public void setMomentumScore (float momentumScore)
    {
        this.momentumScore = momentumScore;
    }

    public String getSubSector ()
    {
        return subSector;
    }

    public void setSubSector (String subSector)
    {
        this.subSector = subSector;
    }

    public String getSector ()
    {
        return sector;
    }

    public void setSector (String sector)
    {
        this.sector = sector;
    }

    @Override
    public int compareTo(Stock stock) {  //stock = value coming from outside world comparing to another "our" stock

        var v1 = this.getDividends().getYield(); //current object
        var v2 = stock.getDividends().getYield(); //object from outside, now compare the two


        return -1 * Float.compare(v1,v2); //multi by -1 to reverse the accending to decending
        //returns a number, if neg knows its less than, if 0 knows its equal, if positive knows its greater

    }
}