package com.darkpiv.currencyconverter.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.darkpiv.currencyconverter.R;
import com.darkpiv.currencyconverter.model.CurrencyName;
import com.darkpiv.currencyconverter.model.CurrencyRate;
import com.darkpiv.currencyconverter.ui.baseui.BaseActivity;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.StringTokenizer;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    public static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }



    @Override
    protected int getRootLayoutId() {
        return R.layout.activity_main;
    }


}