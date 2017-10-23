package com.mashko.andrei.moneytracker;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by АДМИН on 22.10.2017.
 */

public class AddTransactionsActivity extends ActionBarActivity {
    private Toolbar toolbar;
    private EditText title;
    private EditText sum;
    private Button bt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transactions);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        title = (EditText) findViewById(R.id.et_notice);
        sum = (EditText) findViewById(R.id.et_summa);
        bt = (Button) findViewById(R.id.bt_add_trans);


        if(toolbar != null)
        setSupportActionBar(toolbar);

        setTitle(getString(R.string.add_transactions));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transactions transactions =  new Transactions();
                transactions.setTitle(title.getText().toString());
                transactions.setSum(sum.getText().toString());
                transactions.save();
                Toast.makeText(getBaseContext(), "Insert successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
