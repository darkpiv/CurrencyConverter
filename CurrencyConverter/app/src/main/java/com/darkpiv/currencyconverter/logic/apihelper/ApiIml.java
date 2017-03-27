package com.darkpiv.currencyconverter.logic.apihelper;

import com.darkpiv.currencyconverter.logic.baselogic.OnErrorListener;
import com.darkpiv.currencyconverter.logic.baselogic.OnSuccessListener;
import com.darkpiv.currencyconverter.model.ErrorResponse;
import com.darkpiv.currencyconverter.network.NetworkAPI;

import org.json.JSONObject;

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
        Call<String> call = networkAPI.getRate();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    try {
                        String s = response.body();
                        JSONObject object = new JSONObject(s);
                        ls.onSuccess(object.getString("quotes"));

                    } catch (Exception e) {
                        le.onError(new ErrorResponse().setStatus(e.getMessage()));
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                le.onError(new ErrorResponse().setStatus(t.getMessage()));
            }
        });
    }

    public void getName(final OnSuccessListener<String> ls, final OnErrorListener<ErrorResponse> le) {
        Call<String> call = networkAPI.getName();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    try {
                        String s = response.body();
                        JSONObject object = new JSONObject(s);
                        ls.onSuccess(object.getString("currencies"));

                    } catch (Exception e) {
                        le.onError(new ErrorResponse().setStatus(e.getMessage()));
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                le.onError(new ErrorResponse().setStatus(t.getMessage()));
            }

        });
    }
}