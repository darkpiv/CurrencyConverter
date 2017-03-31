package com.darkpiv.currencyconverter.logic.view;

import android.support.annotation.NonNull;

import com.darkpiv.currencyconverter.logic.baselogic.BaseView;
import com.darkpiv.currencyconverter.model.ErrorResponse;

import java.util.ArrayList;

/**
 * Created by darkpiv on 3/27/17.
 */

public interface ConvertFragmentView extends BaseView {
    void onDataUpdated(ArrayList<String> fromAdapter, ArrayList<String> toAdapter);

    void onError(@NonNull ErrorResponse errorResponse);

    void onConverted(String result);
}
