package org.example.springsoap.dto;

public class CandleRaw {

    private String time;
    private boolean complete;
    private CandleMid mid;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public CandleMid getMid() {
        return mid;
    }

    public void setMid(CandleMid mid) {
        this.mid = mid;
    }
}
