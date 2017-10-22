package com.mashko.andrei.moneytracker;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by АДМИН on 22.10.2017.
 */

public class TransactionsFragment extends Fragment {
    private ListView listView;
    private TransactionAdapter transactionAdapter;
    private List<Transactions> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_transactions, container);

        initData();
        transactionAdapter = new TransactionAdapter(getActivity(), data);

        listView = (ListView) view.findViewById(R.id.listview);
        listView.setAdapter(transactionAdapter);

        return view;
    }

    private void initData(){
        data = new ArrayList<>();
        data.add(new Transactions("Phone", new Date(), 25));
        data.add(new Transactions("Phone2", new Date(), 35));
        data.add(new Transactions("Phone3", new Date(), 45));
        data.add(new Transactions("Phone4", new Date(), 55));
        data.add(new Transactions("Phone5", new Date(), 65));
    }
}
