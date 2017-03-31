package com.darkpiv.currencyconverter.model;


public class CurrencyRate extends BaseModel {

    private String code;
    private String rate;
    private int imageId;
    private String fullName;


    public CurrencyRate(String title, String rate) {
        this.code = title;
        this.rate = rate;
    }

    public String getCode() {
        return code;
    }

    public CurrencyRate setCode(String code) {
        this.code = code;
        return this;
    }

    public String getRate() {
        return rate;
    }

    public CurrencyRate setRate(String rate) {
        this.rate = rate;
        return this;
    }

    public int getImageId() {
        return imageId;
    }

    public CurrencyRate setImageId(int imageId) {
        this.imageId = imageId;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public CurrencyRate setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
}
