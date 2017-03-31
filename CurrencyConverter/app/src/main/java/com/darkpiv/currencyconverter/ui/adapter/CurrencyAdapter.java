package com.darkpiv.currencyconverter.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.darkpiv.currencyconverter.R;
import com.darkpiv.currencyconverter.model.CurrencyRate;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by darkpiv on 26/03/2017.
 */

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CurrencyHolder> {

    private ArrayList<CurrencyRate> currencyRates;

    public CurrencyAdapter(ArrayList<CurrencyRate> currencyRates) {
        this.currencyRates = currencyRates;
    }

    @Override
    public CurrencyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_rate, parent, false);
        return new CurrencyHolder(itemView);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public void onBindViewHolder(CurrencyHolder holder, int position) {
        CurrencyRate currencyRate = currencyRates.get(holder.getAdapterPosition());
/*
        holder.ivCountry.setImageResource(currencyRate.getImageId());
*/
        holder.tvName.setText(currencyRate.getCode());
        holder.tvRate.setText(currencyRate.getRate());
        holder.tvFullName.setText(currencyRate.getFullName());
    }

    @Override
    public int getItemCount() {
        return currencyRates == null ? 0 : currencyRates.size();
    }

    public static class CurrencyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_country)
        ImageView ivCountry;
        @BindView(R.id.tv_full_name)
        TextView tvFullName;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_rate)
        TextView tvRate;

        public CurrencyHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
