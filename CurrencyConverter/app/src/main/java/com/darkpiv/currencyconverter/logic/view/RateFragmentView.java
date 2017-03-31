package com.darkpiv.currencyconverter.logic.view;

import com.darkpiv.currencyconverter.logic.baselogic.BaseView;
import com.darkpiv.currencyconverter.model.CurrencyRate;
import com.darkpiv.currencyconverter.model.ErrorResponse;

import java.util.ArrayList;

/**
 * Created by darkpiv on 3/27/17.
 */

public interface RateFragmentView extends BaseView {

    void onDataUpdated(ArrayList<CurrencyRate> rate);
    void onError(ErrorResponse errorResponse);
}
