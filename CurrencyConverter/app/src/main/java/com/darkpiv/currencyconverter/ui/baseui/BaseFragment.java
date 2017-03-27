package com.darkpiv.currencyconverter.ui.baseui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.darkpiv.currencyconverter.logic.baselogic.BaseInteractor;
import com.darkpiv.currencyconverter.network.NetworkAPI;
import com.darkpiv.currencyconverter.network.NetworkModule;

import java.io.File;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by darkpiv on 3/27/17.
 */

public abstract class BaseFragment extends Fragment {
    protected Unbinder unbinder;
    protected View rootView;
    protected File cacheFile;
    protected NetworkAPI networkApi;
    protected BaseInteractor interactor;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        rootView = inflater.inflate(getRootLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, rootView);
        cacheFile = new File(getContext().getCacheDir(), "cache");
        NetworkModule networkModule = new NetworkModule(cacheFile);
        networkApi = networkModule.providesNetworkService(networkModule.provideCall());
        interactor = BaseInteractor.getInstance();

        return rootView;
    }

    @Override
    public void onDestroy() {
        unbinder.unbind();
        cacheFile.delete();
        interactor.removeAllCallbackAndMessages();
        networkApi = null;
        interactor = null;
        super.onDestroy();

    }

    protected View getRootLayout() {
        return rootView;
    }

    protected abstract int getRootLayoutId();

    public NetworkAPI getNetworkApi() {
        return networkApi;
    }

    public BaseInteractor getInteractor() {
        return interactor;
    }
}


