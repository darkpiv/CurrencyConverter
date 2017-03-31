package com.darkpiv.currencyconverter.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by darkpiv on 19/12/2016.
 */

public interface NetworkAPI {

    @GET("list")
    Call<ResponseBody> getName(@Query("access_key") String key);
    @GET("live")
    Call<ResponseBody> getRate(@Query("access_key") String key);

}
