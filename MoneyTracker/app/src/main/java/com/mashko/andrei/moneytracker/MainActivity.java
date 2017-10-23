package com.mashko.andrei.moneytracker;

import android.app.FragmentTransaction;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ListView leftDrawer;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        leftDrawer = (ListView) findViewById(R.id.left_drawer);

        String[] navigationData = new String[]{"Траты", "Категории", "Статистика"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.list_item_menu, navigationData);
        leftDrawer.setAdapter(arrayAdapter);
        leftDrawer.setOnItemClickListener(new DrawerItemOnClickListener());

        if(toolbar != null)
            setSupportActionBar(toolbar);

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.setDrawerListener(drawerToggle);

    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    private class DrawerItemOnClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position){
                case 0:
                    leftDrawer.setItemChecked(position, true);
                    drawerLayout.closeDrawer(leftDrawer);
                    setTitle(getString(R.string.transactions));
                    TransactionsFragment transactionsFragment = new TransactionsFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.content_frame, transactionsFragment);
                    transaction.commit();
                    break;
            }
        }
    }
}
