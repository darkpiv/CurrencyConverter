package com.darkpiv.currencyconverter.model;

public class CurrencyName extends BaseModel{
    public String code;
    public String fullName;

    public CurrencyName(String code, String fullName) {
        this.code = code;
        this.fullName = fullName;
    }
}
