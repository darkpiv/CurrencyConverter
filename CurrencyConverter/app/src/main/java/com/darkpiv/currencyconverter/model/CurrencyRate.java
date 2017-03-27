package com.darkpiv.currencyconverter.model;


public class CurrencyRate extends BaseModel{

    public String code;
    public String rate;
    public int imageId;


    public CurrencyRate(String title, String rate) {
        this.code = title;
        this.rate = rate;
    }


}
