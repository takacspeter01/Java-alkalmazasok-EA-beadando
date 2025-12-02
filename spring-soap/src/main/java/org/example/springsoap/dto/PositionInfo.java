package org.example.springsoap.dto;

public class PositionInfo {

    private String instrument;
    private String longUnits;
    private String longAvgPrice;
    private String shortUnits;
    private String shortAvgPrice;

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getLongUnits() {
        return longUnits;
    }

    public void setLongUnits(String longUnits) {
        this.longUnits = longUnits;
    }

    public String getLongAvgPrice() {
        return longAvgPrice;
    }

    public void setLongAvgPrice(String longAvgPrice) {
        this.longAvgPrice = longAvgPrice;
    }

    public String getShortUnits() {
        return shortUnits;
    }

    public void setShortUnits(String shortUnits) {
        this.shortUnits = shortUnits;
    }

    public String getShortAvgPrice() {
        return shortAvgPrice;
    }

    public void setShortAvgPrice(String shortAvgPrice) {
        this.shortAvgPrice = shortAvgPrice;
    }
}

