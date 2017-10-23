package com.mashko.andrei.moneytracker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by АДМИН on 23.10.2017.
 */

public class CategoryAdapter extends  RecyclerView.Adapter<CategoryAdapter.CardViewHolder> {

    List<Category> categorys;

    public CategoryAdapter(List<Category> categorys) {
        this.categorys = categorys;
    }


    @Override
    public CategoryAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_category, parent, false);
        return new CategoryAdapter.CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        Category category = categorys.get(position);

        holder.title.setText(category.getName());
    }

    @Override
    public int getItemCount() {
        return categorys.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        protected TextView title;

        public CardViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title_category);

        }
    }


}
