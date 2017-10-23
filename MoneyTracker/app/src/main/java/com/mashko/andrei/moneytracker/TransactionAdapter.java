package com.mashko.andrei.moneytracker;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import static android.R.attr.resource;

/**
 * Created by АДМИН on 22.10.2017.
 */

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.CardViewHolder> {

    List<Transactions> transactionses;

    public TransactionAdapter(List<Transactions> transactions) {
        this.transactionses = transactions;
    }


    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        Transactions transactions = transactionses.get(position);

        holder.title.setText(transactions.getTitle());
        //holder.date.setText(transactions.getDate().toString());
        holder.sum.setText(transactions.getSum());

    }

    @Override
    public int getItemCount() {
        return transactionses.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        protected TextView title;
        protected TextView date;
        protected TextView sum;

        public CardViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            date = (TextView) itemView.findViewById(R.id.date);
            sum = (TextView) itemView.findViewById(R.id.sum);
        }
    }
}
