package com.mashko.andrei.moneytracker;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.activeandroid.Model;
import com.activeandroid.query.Select;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by АДМИН on 22.10.2017.
 */

public class TransactionsFragment extends Fragment {

    private RecyclerView recyclerView;
    private TransactionAdapter transactionAdapter;
    private List<Transactions> data = new ArrayList<>();
    private FloatingActionButton fab;
    private Category category;

    public TransactionsFragment(){};

    public TransactionsFragment(Category category){
        this.category=category;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_transactions, container, false);

        data = getAllTransactions();
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

    public static List<Transactions> getAllTransactions(){
        return new Select().from(Transactions.class).orderBy("date_tr DESC").execute();
    }

    public  List<Transactions> getTransactions(){
        if(this.category == null)
        return new Select().from(Transactions.class).orderBy("date_tr DESC").execute();
        else return CategorysFragment.getTransactionsCategory(this.category);
    }



}
