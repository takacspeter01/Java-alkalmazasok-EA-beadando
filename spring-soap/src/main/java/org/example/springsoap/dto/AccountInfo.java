package org.example.springsoap.dto;

public class AccountInfo {

    private String id;
    private String currency;
    private String balance;
    private String unrealizedPL;
    private String realizedPL;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getUnrealizedPL() {
        return unrealizedPL;
    }

    public void setUnrealizedPL(String unrealizedPL) {
        this.unrealizedPL = unrealizedPL;
    }

    public String getRealizedPL() {
        return realizedPL;
    }

    public void setRealizedPL(String realizedPL) {
        this.realizedPL = realizedPL;
    }
}
