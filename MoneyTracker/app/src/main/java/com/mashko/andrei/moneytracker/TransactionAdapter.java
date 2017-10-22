package com.mashko.andrei.moneytracker;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

public class TransactionAdapter extends ArrayAdapter<Transactions> {

    List<Transactions> transactionses;

    public TransactionAdapter(@NonNull Context context, List<Transactions> transactions) {
        super(context, 0, transactions);
        this.transactionses = transactions;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Transactions transactions = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView date = (TextView) convertView.findViewById(R.id.date);
        TextView sum = (TextView) convertView.findViewById(R.id.sum);

        title.setText(transactions.getTitle());
        date.setText(transactions.getDate().toString());
        sum.setText(transactions.getSum().toString());

        return convertView;
    }
}
