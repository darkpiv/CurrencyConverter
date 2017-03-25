package com.darkpiv.firsttemplate.logic.presenter;

import android.support.annotation.NonNull;

import com.darkpiv.currencyconverter.logic.baselogic.BasePresenter;
import com.darkpiv.currencyconverter.logic.view.MainView;
import com.darkpiv.currencyconverter.network.NetworkAPI;


/**
 * Created by darkpiv on 27/12/2016.
 */

public class MainActivityPresenter extends BasePresenter<MainView> {
    private static final String TAG = MainActivityPresenter.class.getSimpleName();
    private NetworkAPI networkAPI;

    public MainActivityPresenter() {
        // empty constructor
    }

    public MainActivityPresenter setNetworkAPI(NetworkAPI networkAPI) {
        this.networkAPI = networkAPI;
        return this;
    }

    @Override
    public void onViewAttached(@NonNull MainView view) {
    }

    @Override
    public void onViewDetached() {

    }


}
