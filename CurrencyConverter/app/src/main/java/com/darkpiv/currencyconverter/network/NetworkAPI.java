package com.darkpiv.currencyconverter.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by darkpiv on 19/12/2016.
 */

public interface NetworkAPI {

    @GET("posts")
    Call<ResponseBody> getPosts();

}
