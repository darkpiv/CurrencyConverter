package com.darkpiv.currencyconverter.logic.apilistener;

import android.support.annotation.NonNull;

/**
 * Created by darkpiv on 29/12/2016.
 */

public interface OnSuccessListener<D> {
    void onSuccess(@NonNull D data);

}
