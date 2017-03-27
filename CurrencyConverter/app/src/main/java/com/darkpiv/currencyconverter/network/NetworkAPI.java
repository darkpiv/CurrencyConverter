package com.darkpiv.currencyconverter.network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by darkpiv on 19/12/2016.
 */

public interface NetworkAPI {

    @GET("list?access_key=79660454f39ce2075c55af40a54dbfc5")
    Call<String> getName();
    @GET("live?access_key=79660454f39ce2075c55af40a54dbfc5")
    Call<String> getRate();

}
