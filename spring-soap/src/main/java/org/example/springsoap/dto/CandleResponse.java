package org.example.springsoap.dto;

import java.util.List;

public class CandleResponse {

    private String instrument;
    private String granularity;
    private List<CandleRaw> candles;

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getGranularity() {
        return granularity;
    }

    public void setGranularity(String granularity) {
        this.granularity = granularity;
    }

    public List<CandleRaw> getCandles() {
        return candles;
    }

    public void setCandles(List<CandleRaw> candles) {
        this.candles = candles;
    }
}
