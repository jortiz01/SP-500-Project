package edu.citytech.stocks.stocks.model;

import java.util.Arrays;
import java.util.Map;

public class Dividends
{
    private Map<Integer, Float>[] months;

    private float yield;

    private String frequency;

    @Override
    public String toString() {
        return "Dividends{" +
                "months=" + Arrays.toString(months) +
                ", yield=" + yield +
                ", frequency='" + frequency + '\'' +
                '}';
    }

    public Map<Integer, Float>[] getMonths() {
        return months;
    }

    public void setMonths(Map<Integer, Float>[] months) {
        this.months = months;
    }

    public float getYield ()
    {
        return yield;
    }

    public void setYield (float yield)
    {
        this.yield = yield;
    }

    public String getFrequency ()
    {
        return frequency;
    }

    public void setFrequency (String frequency)
    {
        this.frequency = frequency;
    }

}