package com.darkpiv.currencyconverter.logic.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.darkpiv.currencyconverter.R;
import com.darkpiv.currencyconverter.logic.apihelper.ApiIml;
import com.darkpiv.currencyconverter.logic.baselogic.BasePresenter;
import com.darkpiv.currencyconverter.logic.view.RateFragmentView;
import com.darkpiv.currencyconverter.model.CurrencyName;
import com.darkpiv.currencyconverter.model.CurrencyRate;
import com.darkpiv.currencyconverter.model.ErrorResponse;
import com.darkpiv.currencyconverter.network.NetworkAPI;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * Created by darkpiv on 3/27/17.
 */

public class RatePresenter extends BasePresenter<RateFragmentView> {
    private ArrayList<CurrencyRate> list_currency_rate_data;
    private ArrayList<CurrencyName> list_currency_name_data;
    private ApiIml apiIml;
    private NetworkAPI networkAPI;

    public void setNetworkAPI(NetworkAPI networkAPI) {
        this.networkAPI = networkAPI;
    }

    @Override
    public void onViewAttached(@NonNull RateFragmentView view) {
        apiIml = new ApiIml(networkAPI);
        list_currency_name_data = new ArrayList<>();
        list_currency_rate_data = new ArrayList<>();
    }

    @Override
    public void onViewDetached() {

    }

    public void refreshData() {
        apiIml.getRate(this::onGetRateSuccess, this::onGetRateFailure);
    }

    private void onGetRateSuccess(String rate) {
        String temp1 = rate;
        temp1 = temp1.replace("{", "");
        temp1 = temp1.replace("}", "");
        temp1 = temp1.replace("\"", "");
        temp1 = temp1.replace("\n", "");

        StringTokenizer stok = new StringTokenizer(temp1, ",");

        while (stok.hasMoreElements()) {

            String temp = stok.nextElement().toString();

            String split[] = temp.split(":");

            double amount = Double.parseDouble(split[1]);

            DecimalFormat df1 = new DecimalFormat("#.###", new DecimalFormatSymbols(Locale.US));

            String refinedNumber = df1.format(amount);

            split[1] = String.valueOf(refinedNumber);

            list_currency_rate_data.add(new CurrencyRate(split[0], split[1]).setImageId(R.drawable.aoa));

        }

        Collections.sort(list_currency_rate_data, new Comparator<CurrencyRate>() {
            @Override
            public int compare(CurrencyRate r1, CurrencyRate r2) {
                return r1.getCode().compareTo(r2.getCode());
            }
        });

        apiIml.getName(this::onGetNameSuccess, this::onGetNameFailure);
    }

    private void onGetNameSuccess(String name) {
        String temp = name;
        temp = temp.replace("{", "");
        temp = temp.replace("}", "");
        temp = temp.replace("\"", "");
        StringTokenizer stoke = new StringTokenizer(temp, ",");
        while (stoke.hasMoreElements()) {

            String temp1 = stoke.nextElement().toString();
            String split[] = temp1.split(":");

            list_currency_name_data.add(new CurrencyName(split[0], split[1]));

        }

        Collections.sort(list_currency_name_data, new Comparator<CurrencyName>() {
            @Override
            public int compare(CurrencyName n1, CurrencyName n2) {
                return n1.getCode().compareTo(n2.getCode());
            }
        });

        for (int i = 0; i < list_currency_rate_data.size(); i++) {
            list_currency_rate_data.get(i).setFullName(list_currency_name_data.get(i).getFullName());
        }

        getView().onDataUpdated(list_currency_rate_data);
        Log.d("XX", "onGetNameSuccess: " + list_currency_name_data.size());
        Log.d("xx", "onGetNameSuccess: " + list_currency_rate_data.size());
        Log.d("", "onGetNameSuccess: ");

    }

    private void onGetNameFailure(ErrorResponse errorResponse) {
        Log.d("XXX", "onGetRateFailure: " + errorResponse.getStatus());
    }

    private void onGetRateFailure(ErrorResponse errorResponse) {
        Log.d("XXX", "onGetRateFailure: " + errorResponse.getStatus());
    }

}
