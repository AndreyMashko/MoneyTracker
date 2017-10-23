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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by АДМИН on 23.10.2017.
 */

public class CategorysFragment extends Fragment {

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    private List<Category> data = new ArrayList<>();
    private FloatingActionButton fab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_categorys, container, false);

        data = getAllCategorys();
        categoryAdapter = new CategoryAdapter(data);

        recyclerView = (RecyclerView) view.findViewById(R.id.categorys_list);
        fab = (FloatingActionButton) view.findViewById(R.id.fab_add_category);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(categoryAdapter);


        fab.attachToRecyclerView(recyclerView);
        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(getActivity(), AddTransactionsActivity.class);
                getActivity().startActivity(intent);*/
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.dialog_add_category);
                dialog.setCanceledOnTouchOutside(true);
                dialog.setTitle(getString(R.string.add_category));

                final EditText title = (EditText) dialog.findViewById(R.id.et_category);
                Button bt = (Button) dialog.findViewById(R.id.bt_add_category);

                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Category category = new Category();

                        String str = title.getText().toString();

                        category.setName(str);


                        category.save();

                        Toast.makeText(getActivity(), category.getName(), Toast.LENGTH_SHORT).show();
                        dialog.hide();
                        Fragment frg = null;
                        frg = getActivity().getFragmentManager().findFragmentById(R.id.content_frame);
                        final FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.detach(frg);
                        ft.attach(frg);
                        ft.commit();
                    }
                });
                dialog.show();

            }
        });

        return view;
    }

    public static List<Category> getAllCategorys(){
        return new Select().from(Category.class).execute();
    }

    public static Category getCategory(String name){
        return new Select().from(Category.class).where("name_cat = ?", name).executeSingle();
    }


}
