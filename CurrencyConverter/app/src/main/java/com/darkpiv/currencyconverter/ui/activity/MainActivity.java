package com.darkpiv.currencyconverter.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.darkpiv.currencyconverter.R;
import com.darkpiv.currencyconverter.ui.baseui.BaseActivity;
import com.darkpiv.currencyconverter.ui.baseui.BaseFragment;
import com.darkpiv.currencyconverter.ui.baseui.SmartFragmentStatePagerAdapter;
import com.darkpiv.currencyconverter.ui.fragment.ConvertFragment;
import com.darkpiv.currencyconverter.ui.fragment.RateFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.vp_main)
    ViewPager vpMain;
    MyPagerAdapter adapterViewPager;
    @BindView(R.id.tab_layout)
    TabLayout slidingTabs;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpMain.setAdapter(adapterViewPager);
        slidingTabs.setupWithViewPager(vpMain);
        vpMain.setCurrentItem(0);
        vpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected: " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    @Override
    protected int getRootLayoutId() {
        return R.layout.activity_main;
    }

    public static class MyPagerAdapter extends SmartFragmentStatePagerAdapter<BaseFragment> {
        private static int NUM_ITEMS = 2;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return ConvertFragment.newInstance(new Bundle());
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return RateFragment.newInstance(new Bundle());
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Convert";
                case 1:
                    return "Rate";

            }
            return "";

        }

    }

}