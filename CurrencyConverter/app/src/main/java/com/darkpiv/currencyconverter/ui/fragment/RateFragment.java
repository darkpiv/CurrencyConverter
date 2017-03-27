package com.darkpiv.currencyconverter.ui.fragment;

import com.darkpiv.currencyconverter.logic.baselogic.BaseInteractor;
import com.darkpiv.currencyconverter.network.NetworkAPI;
import com.darkpiv.currencyconverter.ui.baseui.BaseFragment;

/**
 * Created by darkpiv on 3/27/17.
 */

public class RateFragment extends BaseFragment {
    @Override
    protected int getRootLayoutId() {
        return 0;
    }

    @Override
    public NetworkAPI getNetworkApi() {
        return super.getNetworkApi();
    }

    @Override
    public BaseInteractor getInteractor() {
        return super.getInteractor();
    }
}
