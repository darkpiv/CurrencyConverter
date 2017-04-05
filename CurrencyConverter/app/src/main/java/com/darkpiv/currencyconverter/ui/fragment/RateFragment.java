package com.darkpiv.currencyconverter.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.darkpiv.currencyconverter.R;
import com.darkpiv.currencyconverter.logic.baselogic.BaseInteractor;
import com.darkpiv.currencyconverter.logic.presenter.RatePresenter;
import com.darkpiv.currencyconverter.logic.view.RateFragmentView;
import com.darkpiv.currencyconverter.model.CurrencyRate;
import com.darkpiv.currencyconverter.model.ErrorResponse;
import com.darkpiv.currencyconverter.network.NetworkAPI;
import com.darkpiv.currencyconverter.ui.adapter.CurrencyAdapter;
import com.darkpiv.currencyconverter.ui.baseui.BaseFragment;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import butterknife.BindView;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by darkpiv on 3/27/17.
 */

public class RateFragment extends BaseFragment implements RateFragmentView {

    @BindView(R.id.rv_rate)
    RecyclerView rvRate;
    RatePresenter ratePresenter;

    public static RateFragment newInstance(Bundle bundle) {
        RateFragment fragment = new RateFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.fragment_rate;
    }

    @Override
    public NetworkAPI getNetworkApi() {
        return super.getNetworkApi();
    }

    @Override
    public BaseInteractor getInteractor() {
        return super.getInteractor();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        ratePresenter = new RatePresenter();
        ratePresenter.setNetworkAPI(getNetworkApi());
        ratePresenter.setContext(getContext());
        ratePresenter.attachView(this);
        refreshData();
        return rootView;
    }

    private void refreshData() {
        getInteractor().runOnUiThreadAfter(new RefreshData(ratePresenter), 500);
    }

    @Override
    public void onDataUpdated(ArrayList<CurrencyRate> rate) {
        CurrencyAdapter adapter = new CurrencyAdapter(rate);

        rvRate.setItemAnimator(new SlideInUpAnimator());
        rvRate.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvRate.setAdapter(adapter);
    }

    @Override
    public void onError(ErrorResponse errorResponse) {

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public static class RefreshData implements Runnable {

        public WeakReference<RatePresenter> ref;

        public RefreshData(RatePresenter presenter) {
            this.ref = new WeakReference<RatePresenter>(presenter);
        }

        @Override
        public void run() {
            if (ref != null) {
                ref.get().refreshData();
            }
        }
    }
}
