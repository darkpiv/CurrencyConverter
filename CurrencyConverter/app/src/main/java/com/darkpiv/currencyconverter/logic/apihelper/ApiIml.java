package com.darkpiv.currencyconverter.logic.apihelper;

import android.util.Log;

import com.darkpiv.currencyconverter.logic.baselogic.OnErrorListener;
import com.darkpiv.currencyconverter.logic.baselogic.OnSuccessListener;
import com.darkpiv.currencyconverter.model.ErrorResponse;
import com.darkpiv.currencyconverter.network.NetworkAPI;
import com.darkpiv.currencyconverter.util.APIConfig;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by darkpiv on 3/27/17.
 */

public class ApiIml {
    private NetworkAPI networkAPI;

    public ApiIml() {
    }

    public ApiIml(NetworkAPI networkAPI) {
        this.networkAPI = networkAPI;
    }

    public void getRate(final OnSuccessListener<String> ls, final OnErrorListener<ErrorResponse> le) {
        Call<ResponseBody> call = networkAPI.getRate(APIConfig.API_KEY);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String s = response.body().string();
                        JSONObject object = new JSONObject(s);
                        ls.onSuccess(object.getString("quotes"));

                    } catch (Exception e) {
                        e.printStackTrace();
                        le.onError(new ErrorResponse().setStatus(e.getMessage()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
                le.onError(new ErrorResponse().setStatus(t.getMessage()));
            }
        });
    }

    public void getName(final OnSuccessListener<String> ls, final OnErrorListener<ErrorResponse> le) {
        Call<ResponseBody> call = networkAPI.getName(APIConfig.API_KEY);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String s = response.body().string();
                        Log.d("XXX", "onResponse: " + s);
                        JSONObject object = new JSONObject(s);
                        ls.onSuccess(object.getString("currencies"));

                    } catch (Exception e) {
                        e.printStackTrace();
                        le.onError(new ErrorResponse().setStatus(e.getMessage()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
                le.onError(new ErrorResponse().setStatus(t.getMessage()));
            }

        });
    }
}