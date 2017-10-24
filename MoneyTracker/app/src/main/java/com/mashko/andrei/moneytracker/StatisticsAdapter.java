package com.mashko.andrei.moneytracker;

import android.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by АДМИН on 24.10.2017.
 */

public class StatisticsAdapter extends RecyclerView.Adapter<StatisticsAdapter.CardViewHolder> {

    List<Category> categorys;

    public StatisticsAdapter(List<Category> categorys) {
        this.categorys = categorys;
    }


    @Override
    public StatisticsAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_statistics, parent, false);
        return new StatisticsAdapter.CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StatisticsAdapter.CardViewHolder holder, int position) {
        Category category = categorys.get(position);

        holder.categoryName.setText(category.getName());
        holder.sumResult.setText(CategorysFragment.getSumResCategory(category).toString());
    }

    @Override
    public int getItemCount() {
        return categorys.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        protected TextView categoryName;
        protected TextView sumResult;

        public CardViewHolder(final View itemView) {
            super(itemView);

            categoryName = (TextView) itemView.findViewById(R.id.category_name);
            sumResult = (TextView) itemView.findViewById(R.id.sum_res);


        }
    }


}