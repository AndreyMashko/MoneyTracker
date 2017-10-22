package com.mashko.andrei.moneytracker;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by АДМИН on 22.10.2017.
 */

public class TransactionsFragment extends Fragment {

    RecyclerView recyclerView;
    TransactionAdapter transactionAdapter;
    List<Transactions> data = new ArrayList<>();
    FloatingActionButton fab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_transactions, container, false);

        initData(data);
        transactionAdapter = new TransactionAdapter(data);

        recyclerView = (RecyclerView) view.findViewById(R.id.trnsactions_list);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(transactionAdapter);

        fab.attachToRecyclerView(recyclerView);
        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddTransactionsActivity.class);
                getActivity().startActivity(intent);
            }
        });

        return view;
    }

    private void initData(List<Transactions> data){
        data.add(new Transactions("Phone", new Date(), 25));
        data.add(new Transactions("Phone2", new Date(), 35));
        data.add(new Transactions("Phone3", new Date(), 45));
        data.add(new Transactions("Phone4", new Date(), 55));
        data.add(new Transactions("Phone5", new Date(), 65));
        data.add(new Transactions("Phone", new Date(), 25));
        data.add(new Transactions("Phone2", new Date(), 35));
        data.add(new Transactions("Phone3", new Date(), 45));
        data.add(new Transactions("Phone4", new Date(), 55));
        data.add(new Transactions("Phone5", new Date(), 65));
        data.add(new Transactions("Phone", new Date(), 25));
        data.add(new Transactions("Phone2", new Date(), 35));
        data.add(new Transactions("Phone3", new Date(), 45));
        data.add(new Transactions("Phone4", new Date(), 55));
        data.add(new Transactions("Phone5", new Date(), 65));
    }


}
