package com.darkpiv.currencyconverter.ui.activity;

import android.os.Bundle;

import com.darkpiv.currencyconverter.R;
import com.darkpiv.currencyconverter.ui.baseui.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.activity_main;
    }
}
