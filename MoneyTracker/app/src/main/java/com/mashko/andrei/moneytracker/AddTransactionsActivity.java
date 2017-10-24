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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by АДМИН on 22.10.2017.
 */

public class AddTransactionsActivity extends ActionBarActivity {
    private Toolbar toolbar;
    private EditText title;
    private EditText sum;
    private Button bt;
    private Spinner spinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transactions);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        title = (EditText) findViewById(R.id.et_notice);
        sum = (EditText) findViewById(R.id.et_summa);
        bt = (Button) findViewById(R.id.bt_add_trans);
        spinner = (Spinner) findViewById(R.id.spinner_catigories);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, getCategoriesName());
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);


        if(toolbar != null)
        setSupportActionBar(toolbar);

        setTitle(getString(R.string.add_transactions));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transactions transactions =  new Transactions();
                String trTitle = title.getText().toString().trim();
                String trSum = sum.getText().toString().trim();
                Category categr = CategorysFragment.getCategory((String)spinner.getSelectedItem());

                if(trTitle.length() != 0 &&
                        trSum.length() != 0 &&
                        categr != null){
                    transactions.setCategory(categr);
                    transactions.setTitle(trTitle);
                    transactions.setSum(trSum);
                    transactions.save();
                    Toast.makeText(getBaseContext(), "Input success", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(getBaseContext(), "Input error!", Toast.LENGTH_SHORT).show();
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
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static String[] getCategoriesName() {
        List<Category> categoryList = CategorysFragment.getAllCategorys();
        String[] categoriesName = new String[categoryList.size()];
        for(int i = 0; i<categoriesName.length; i++)
            categoriesName[i] = categoryList.get(i).getName();

        return categoriesName;
    }

}
