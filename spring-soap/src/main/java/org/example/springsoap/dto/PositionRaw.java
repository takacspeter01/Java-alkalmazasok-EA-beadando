package org.example.springsoap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PositionRaw {

    private String instrument;

    @JsonProperty("long")
    private PositionSide longSide;

    @JsonProperty("short")
    private PositionSide shortSide;

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public PositionSide getLongSide() {
        return longSide;
    }

    public void setLongSide(PositionSide longSide) {
        this.longSide = longSide;
    }

    public PositionSide getShortSide() {
        return shortSide;
    }

    public void setShortSide(PositionSide shortSide) {
        this.shortSide = shortSide;
    }
}
