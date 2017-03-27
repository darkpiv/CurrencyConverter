package com.darkpiv.currencyconverter.logic.view;

import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.darkpiv.currencyconverter.logic.baselogic.BaseView;
import com.darkpiv.currencyconverter.model.ErrorResponse;

/**
 * Created by darkpiv on 3/27/17.
 */

public interface ConvertFragmentView extends BaseView {
    void onDataUpdated(ArrayAdapter<String> fromAdapter, ArrayAdapter<String> toAdapter);

    void onError(@NonNull ErrorResponse errorResponse);
}
