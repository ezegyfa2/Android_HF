package com.example.lab6;

public class Currency {
    private int imageId;
    private String shortName;
    private String longName;
    private double buy;
    private double sell;

    public Currency(int imageId, String shortName, String longName, double buy, double sell) {
        this.imageId = imageId;
        this.shortName = shortName;
        this.longName = longName;
        this.buy = buy;
        this.sell = sell;
    }

    public int getImageId() {
        return imageId;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }

    public double getBuy() {
        return buy;
    }

    public double getSell() {
        return sell;
    }
}
