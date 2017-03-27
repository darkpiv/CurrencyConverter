package com.darkpiv.currencyconverter.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

import butterknife.BindView;
import butterknife.OnClick;

import static android.content.ContentValues.TAG;

/**
 * Created by darkpiv on 3/27/17.
 */

public class ConvertFragment extends BaseFragment implements ConvertFragmentView {

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

        edtInputAmount.setBackgroundResource(R.drawable.edit_txt_bg);

        spnFrom.setOnItemClickListener((parent, view, position, id) -> {
            Log.d(TAG, "onItemSelected: from" + position);
            convertPresenter.setIdFrom(position);
        });

        spnTo.setOnItemClickListener((parent, view, position, id) -> {
                    Log.d(TAG, "onItemSelected: to" + position);
                    convertPresenter.setIdTo(position);
                }
        );

        edtInputAmount.setOnFocusChangeListener((view, hasFocus) -> {
            if (!hasFocus) {
                convertPresenter.setAmount(Integer.parseInt(edtInputAmount.getText().toString()));
            }

        });
        convertPresenter.refreshData();
        return rootView;
    }


    @Override
    public void onDataUpdated(ArrayAdapter<String> fromAdapter, ArrayAdapter<String> toAdapter) {
        spnFrom.setAdapter(fromAdapter);
        spnTo.setAdapter(toAdapter);
        spnFrom.setBackgroundResource(R.drawable.oval_bg);
        spnTo.setBackgroundResource(R.drawable.oval_bg);
    }

    @Override
    public void onError(@NonNull ErrorResponse errorResponse) {

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
