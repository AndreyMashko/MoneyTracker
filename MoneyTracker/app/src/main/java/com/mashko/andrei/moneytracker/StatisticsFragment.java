package com.mashko.andrei.moneytracker;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by АДМИН on 24.10.2017.
 */

public class StatisticsFragment extends Fragment {

    private RecyclerView recyclerView;
    private StatisticsAdapter statisticsAdapter;
    private List<Category> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_statistics, container, false);

        data = getAllCategorys();
        statisticsAdapter = new StatisticsAdapter(data);

        recyclerView = (RecyclerView) view.findViewById(R.id.categorys_list);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(statisticsAdapter);


        return view;
    }

    public static List<Category> getAllCategorys() {
        return new Select().from(Category.class).execute();
    }
}