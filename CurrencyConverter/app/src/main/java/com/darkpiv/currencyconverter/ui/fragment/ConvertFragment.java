package com.darkpiv.currencyconverter.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.darkpiv.currencyconverter.R;
import com.darkpiv.currencyconverter.logic.baselogic.BaseInteractor;
import com.darkpiv.currencyconverter.logic.presenter.ConvertPresenter;
import com.darkpiv.currencyconverter.logic.view.ConvertFragmentView;
import com.darkpiv.currencyconverter.model.ErrorResponse;
import com.darkpiv.currencyconverter.network.NetworkAPI;
import com.darkpiv.currencyconverter.ui.baseui.BaseFragment;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by darkpiv on 3/27/17.
 */

public class ConvertFragment extends BaseFragment implements ConvertFragmentView {
    public static final String TAG = ConvertFragment.class.getSimpleName();
    @BindView(R.id.edt_input_amount)
    MaterialEditText edtInputAmount;
    @BindView(R.id.spn_from)
    BetterSpinner spnFrom;
    @BindView(R.id.spn_to)
    BetterSpinner spnTo;
    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.btn_convert)
    Button btnConvert;
    ConvertPresenter convertPresenter;
    private ArrayAdapter<String> fromAdapter, toAdapter;

    public static ConvertFragment newInstance(Bundle bundle) {
        ConvertFragment fragment = new ConvertFragment();
        fragment.setArguments(bundle);
        return fragment;

    }

    @OnClick(R.id.btn_convert)
    public void convert(View view) {
        convertPresenter.convert();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

       /* ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < list_currency_name_data.size(); i++) {
            strings.add(list_currency_name_data.get(i).code);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_dropdown_item_1line, strings);
*/
        convertPresenter = new ConvertPresenter();
        convertPresenter.setContext(getContext());
        convertPresenter.setNetworkAPI(getNetworkApi());
        convertPresenter.attachView(this);
        convertPresenter.refreshData();


        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onDataUpdated(ArrayList<String> from, ArrayList<String> to) {
        fromAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_dropdown_item_1line, from);
        toAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, to);
        spnFrom.setAdapter(fromAdapter);
        spnTo.setAdapter(toAdapter);
        spnFrom.setBackgroundResource(R.drawable.oval_bg);
        spnTo.setBackgroundResource(R.drawable.oval_bg);
        spnFrom.setOnItemClickListener((parent, view, position, id) -> {
            convertPresenter.setIdFrom(position);
        });

        spnTo.setOnItemClickListener((parent, view, position, id) -> {
            Log.d(TAG, "onItemSelected: to" + position);
            convertPresenter.setIdTo(position);
        });

        edtInputAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s))
                    convertPresenter.setAmount(Integer.parseInt(s.toString()));
                else
                    convertPresenter.setAmount(0);
            }
        });
    }

    @Override
    public void onError(@NonNull ErrorResponse errorResponse) {

    }

    @Override
    public void onConverted(String result) {
        tvResult.setText(result);
    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.fragment_convert;
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
