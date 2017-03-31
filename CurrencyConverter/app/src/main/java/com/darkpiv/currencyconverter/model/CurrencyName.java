package com.darkpiv.currencyconverter.model;

public class CurrencyName extends BaseModel{
    private String code;
    private String fullName;

    public CurrencyName(String code, String fullName) {
        this.code = code;
        this.fullName = fullName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
