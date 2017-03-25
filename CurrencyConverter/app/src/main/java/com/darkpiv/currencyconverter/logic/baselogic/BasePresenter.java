package com.darkpiv.currencyconverter.logic.baselogic;

import android.support.annotation.NonNull;

/**
 * Created by darkpiv on 19/12/2016.
 */

public abstract class BasePresenter<V extends BaseView> {
    private V view;

    public abstract void onViewAttached(@NonNull V view);

    public abstract void onViewDetached();

    public boolean isViewAttached() {
        return this.view != null;
    }

    public void attachView(@NonNull V view) {
        this.view = view;
        onViewAttached(view);
    }

    public void detachView() {
        this.view = null;
        onViewDetached();
    }

    public V getView() {
        return view;
    }
}
