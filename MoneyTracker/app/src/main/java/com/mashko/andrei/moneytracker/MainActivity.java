package com.mashko.andrei.moneytracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private TransactionAdapter transactionAdapter;
    private List<Transactions> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        transactionAdapter = new TransactionAdapter(this, data);

        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(transactionAdapter);
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
