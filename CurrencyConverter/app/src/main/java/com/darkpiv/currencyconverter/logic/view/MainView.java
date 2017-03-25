package com.darkpiv.currencyconverter.logic.view;

import android.support.annotation.NonNull;

import com.darkpiv.currencyconverter.logic.baselogic.BaseView;
import com.darkpiv.currencyconverter.model.ErrorResponse;

import java.util.List;

/**
 * Created by darkpiv on 29/12/2016.
 */

public interface MainView extends BaseView {
    void onReceivedComments(@NonNull List<Comment> url);

    void onError(@NonNull ErrorResponse errorResponse);
}
