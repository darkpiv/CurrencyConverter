package com.darkpiv.currencyconverter.ui.baseui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.darkpiv.currencyconverter.logic.baselogic.BaseInteractor;
import com.darkpiv.currencyconverter.network.NetworkAPI;
import com.darkpiv.currencyconverter.network.NetworkModule;

import java.io.File;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by darkpiv on 29/12/2016.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Unbinder unbinder;
    protected File cacheFile;
    protected NetworkAPI networkAPI;
    protected BaseInteractor interactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getRootLayoutId());
        unbinder = ButterKnife.bind(this);
        cacheFile = new File(getCacheDir(), "responses");
        NetworkModule networkModule = new NetworkModule(cacheFile);
        networkAPI = networkModule.providesNetworkService(networkModule.provideCall());
        interactor = new BaseInteractor();

    }

    protected abstract int getRootLayoutId();

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        cacheFile.delete();
        networkAPI = null;
        interactor.removeAllCallbackAndMessages();
        interactor = null;
        super.onDestroy();

    }

    public BaseInteractor getInteractor() {
        return interactor;
    }
}
